package com.haiyu.manager.controller.system;

import com.haiyu.manager.common.utils.TimeCreatLocal;
import com.haiyu.manager.pojo.HealthKnowledge;
import com.haiyu.manager.service.HealthKnowlegeService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParserBase;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DiseaseController
 * @Description
 * @Author 李策
 * @Date 2021-5-05 16:44
 */
@Controller
@RequestMapping("/health")
public class KnowledgeController {

    @Autowired
    private HealthKnowlegeService healthKnowlegeService;

    @RequestMapping("/show")
    private String showHealthKnow(Model model, HttpServletRequest request){


        //健康知识对象合集
        List<HealthKnowledge> healthKnowledges = healthKnowlegeService.getAll();
        //输出集合内容
        for(HealthKnowledge healthKnowledge:healthKnowledges){
            System.out.println(healthKnowledge.toString());
        }
        //获取集合大小
        System.out.println(healthKnowledges.size());
        model.addAttribute("healths",healthKnowledges);
        return "information/show";
    }



    @RequestMapping("/search")
    public String getLuceneKonwledge(Model model, HttpServletRequest request) {

        final String key = request.getParameter("key");
        int totalCount = 0;
        Directory dir = null;

        try {
            // 目录Directory
            dir = FSDirectory.open(TimeCreatLocal.file);
            // 索引读取
            IndexReader reader;
            reader = DirectoryReader.open(dir);
            // 索引查找
            IndexSearcher searcher = new IndexSearcher(reader);
            // 分词器
            Analyzer analyzer = new IKAnalyzer();
            // 查询解析器
            MultiFieldQueryParser parser = new MultiFieldQueryParser(new String[] { "title", "content" }, analyzer);
            // 查询逻辑和
            parser.setDefaultOperator(QueryParserBase.AND_OPERATOR);
            // 获取查询关键字
            Query query = parser.parse(key);
            // 创建排序对象
            Sort sort = new Sort(new SortField("id", SortField.Type.LONG, false));
            // 返回结果
//            TopDocs topDocs = searcher.search(query, end, sort);
            TopDocs topDocs = searcher.search(query,10);
            // 打印总条数
            System.out.println("——————共找到" + topDocs.totalHits + "用例");
            // 数据总量
            totalCount = topDocs.totalHits;

            if(totalCount==0){
                return "information/search";
            }
            // 获取对象数组
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            List<HealthKnowledge> knowledges = new ArrayList<HealthKnowledge>();
            if(scoreDocs.length==0) {
                return "";
            }

            for (int i = 0; i < totalCount; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                Document document = searcher.doc(scoreDoc.doc);
                HealthKnowledge knowledge = new HealthKnowledge();

                Integer id = Integer.parseInt(document.get("id"));
                String title = document.get("title");
                String content = document.get("content");

                knowledge.setId(id);
                knowledge.setTitle(title);
                knowledge.setContent(content);
                knowledges.add(knowledge);
            }
            model.addAttribute("healths",knowledges);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return "information/search";
    }

}
