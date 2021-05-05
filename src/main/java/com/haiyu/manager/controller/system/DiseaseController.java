package com.haiyu.manager.controller.system;

import com.haiyu.manager.pojo.Disease;
import com.haiyu.manager.service.AdminUserService;
import com.haiyu.manager.service.DiseaseService;
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
@RequestMapping("/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    //获取疾病信息
    @RequestMapping("/show")
    private String showDisease(Model model, HttpServletRequest request){

        //创建疾病对象
        Disease disease = new Disease();
        //疾病对象合集
        List<Disease> diseases = new ArrayList<>();
        diseases = diseaseService.getAll();
        //输出集合内容
        for(Disease disease1:diseases){
            System.out.println(disease1.toString());
        }
        //获取集合大小
        System.out.println(diseases.size());
        model.addAttribute("diseases",diseases);
        return "information/show";
    }

}
