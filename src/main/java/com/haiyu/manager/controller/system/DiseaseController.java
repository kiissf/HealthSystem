package com.haiyu.manager.controller.system;

import com.haiyu.manager.common.utils.TimeCreatLocal;
import com.haiyu.manager.pojo.Disease;
import com.haiyu.manager.response.PageDataResult;
import com.haiyu.manager.service.DiseaseService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    //初始化页面
    @RequestMapping("/index")
    private String searchIndex(Model model, HttpServletRequest request) {
        return "information/search";
    }

    //初始化页面
    @RequestMapping("/decide")
    private String search(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String type = request.getParameter("select");
        final String key = request.getParameter("key");
        ModelAndView modelAndView = new ModelAndView();
        if (key == null || key.equals("")) {
            System.out.println("返回");
            return "redirect:/disease/index";
        }
        if (type.equals("疾病搜索")) {
            System.out.println("开始重定向" + type);
            return "forward:/disease/search";
        }


        System.out.println("开始重定向" + type);
//        request.getRequestDispatcher("/disease/index").forward(request,response);
//        return "forward:/disease/index";
        return "forward:/health/search";
    }

    //获取疾病信息
    @RequestMapping("/show")
    @ResponseBody
    private PageDataResult showDisease(Model model, HttpServletRequest request) {
        PageDataResult pdr = new PageDataResult();
        //疾病对象合集
        List<Disease> diseases = diseaseService.getAll();
        //输出集合内容
        for (Disease disease : diseases) {
            System.out.println(disease.toString());
        }
        pdr.setCode(200);
        pdr.setTotals(diseases.size());
        pdr.setList(diseases);
        return pdr;
    }

    //跳转某一选项的页面显示
    @RequestMapping("/diseaseManager")
    private String noticeManger() {
        return "information/diseaseinfo";
    }

    //在js中点击显示详情跳转到静态页面
    @RequestMapping("/diseaseshow")
    private String noticeShow() {
        return "information/diseasedetail";
    }

    @RequestMapping(value = "/showDisease")
    @ResponseBody
    public int setSessNotice(int id, HttpSession session) {
        int flag = 0;
        Disease disease = diseaseService.getById(id);
        if (disease != null) {
            flag = 1;
            session.setAttribute("sessDisease", disease);
        }
        return flag;
    }

    //搜索
    @RequestMapping("/search")
    public String searchLuceneDisease(Model model, HttpServletRequest request) {

        final String key = request.getParameter("key");
        int totalCount = 0;
        Directory dir = null;

        try {
            // 目录Directory
            dir = FSDirectory.open(TimeCreatLocal.file2);
            // 索引读取
            IndexReader reader;
            reader = DirectoryReader.open(dir);
            // 索引查找
            IndexSearcher searcher = new IndexSearcher(reader);
            // 分词器
            Analyzer analyzer = new IKAnalyzer();
            // 查询解析器
            MultiFieldQueryParser parser = new MultiFieldQueryParser(new String[]{"name", "description"}, analyzer);
            // 查询逻辑和
            parser.setDefaultOperator(QueryParserBase.AND_OPERATOR);
            // 获取查询关键字
            Query query = parser.parse(key);
            // 创建排序对象
            Sort sort = new Sort(new SortField("id", SortField.Type.LONG, false));
            // 返回结果
//            TopDocs topDocs = searcher.search(query, end, sort);
            TopDocs topDocs = searcher.search(query, 10);
            // 打印总条数
            System.out.println("——————共找到" + topDocs.totalHits + "用例");

            // 数据总量
            totalCount = topDocs.totalHits;

            if (totalCount == 0) {
                return "information/search";
            }

            // 获取对象数组
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            List<Disease> diseases = new ArrayList<Disease>();
            if (scoreDocs.length == 0) {
                return "";
            }

            for (int i = 0; i < totalCount; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                Document document = searcher.doc(scoreDoc.doc);
                Disease disease = new Disease();

                Integer id = Integer.parseInt(document.get("id"));
                String name = document.get("name");
                String taboo = document.get("taboo");
                String description = document.get("description");
                String prevention = document.get("prevention");

                disease.setId(id);
                disease.setDisName(name);
                disease.setDisDescription(description);
                disease.setDisPrevention(prevention);
                disease.setDisTaboo(taboo);
                diseases.add(disease);
            }
            model.addAttribute("diseases", diseases);
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
