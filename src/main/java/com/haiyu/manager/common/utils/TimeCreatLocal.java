package com.haiyu.manager.common.utils;

import com.haiyu.manager.pojo.Disease;
import com.haiyu.manager.pojo.HealthKnowledge;
import com.haiyu.manager.service.DiseaseService;
import com.haiyu.manager.service.HealthKnowlegeService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName TimeCreatLocal
 * @Description
 * @Author 李策
 * @Date 2021-4-17 11:56
 */

@Component
@EnableScheduling
public class TimeCreatLocal {
    //索引存放物理路径
    public static final String INDEXPATH = "D://Lucene//HealthSystem/Knowledge";
    public static final String INDEXPATH2 = "D://Lucene//HealthSystem/Disease";
    public static File file = new File(INDEXPATH);
    public static File file2 = new File(INDEXPATH2);
    @Autowired
    private HealthKnowlegeService knowlegeService;

    @Autowired
    private DiseaseService diseaseService;
    //分词器
    Analyzer analyzer = new IKAnalyzer();
    //定时任务
//	@Scheduled(cron = "0 */360 * * * ?")
    @Scheduled(fixedDelay = 500000)
    //指定时间间隔
    private void creatIndex() {
        System.out.println("==================================");
        System.out.println("——————健康管理系统更新索引库——————");
        System.out.println("==================================");
        try {
            //索引目录
            Directory dir = FSDirectory.open(file);
            //索引写出器配置
            IndexWriterConfig config = new IndexWriterConfig(Version.LATEST,analyzer);
            config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            //索引写出器
            IndexWriter writer = new IndexWriter(dir,config);
            //插入健康知识数据
            List<HealthKnowledge> knowledges = knowlegeService.getAll();
            System.out.println("——————————本次共添加:  " +knowledges.size()+"  条健康知识数据———————————");
            writer.deleteAll();
            for(HealthKnowledge knowledge:knowledges) {
                Document doc = new Document();
                String id = knowledge.getId()+"";
                String title = knowledge.getTitle();
                String content = knowledge.getContent();
                doc.add(new StringField("id",id, Field.Store.YES));
                doc.add(new TextField("title",title, Field.Store.YES));
                doc.add(new TextField("content",content, Field.Store.YES));
                writer.addDocument(doc);
            }

            //提交
            writer.commit();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            //索引目录
            Directory dir = FSDirectory.open(file2);
            //索引写出器配置
            IndexWriterConfig config = new IndexWriterConfig(Version.LATEST,analyzer);
            config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            //索引写出器
            IndexWriter writer = new IndexWriter(dir,config);
            //插入疾病知识数据
            List<Disease> diseases = diseaseService.getAll();
            System.out.println("—————————— 本次共添加:  " +diseases.size()+"  条疾病知识数据———————————");

            for(Disease disease:diseases) {
                Document doc = new Document();
                String id = disease.getId()+"";
                String name = disease.getDisName();
                String description = disease.getDisDescription();
                String taboo = disease.getDisTaboo();
                String prevention = disease.getDisPrevention();
                doc.add(new StringField("id",id, Field.Store.YES));
                doc.add(new TextField("name",name, Field.Store.YES));
                doc.add(new TextField("description",description, Field.Store.YES));
                doc.add(new TextField("taboo",taboo, Field.Store.YES));
                doc.add(new TextField("prevention",prevention, Field.Store.YES));
                writer.addDocument(doc);
            }
            //提交
            writer.commit();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("==================================");
        System.out.println("——————健康系统索引库更新完毕——————");
        System.out.println("==================================");
    }
}

