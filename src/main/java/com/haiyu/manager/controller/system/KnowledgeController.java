package com.haiyu.manager.controller.system;

import com.haiyu.manager.pojo.Disease;
import com.haiyu.manager.pojo.HealthKnowledge;
import com.haiyu.manager.service.DiseaseService;
import com.haiyu.manager.service.HealthKnowlegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
        List<HealthKnowledge> healthKnowledges = new ArrayList<>();
        healthKnowledges = healthKnowlegeService.getAll();
        //输出集合内容
        for(HealthKnowledge healthKnowledge1:healthKnowledges){
            System.out.println(healthKnowledge1.toString());
        }
        //获取集合大小
        System.out.println(healthKnowledges.size());
        model.addAttribute("healths",healthKnowledges);
        return "information/show";
    }

}
