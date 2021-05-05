package com.haiyu.manager.controller.system;

import com.haiyu.manager.pojo.Consultant;
import com.haiyu.manager.pojo.Notice;
import com.haiyu.manager.service.ConsultantService;
import com.haiyu.manager.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ConsultController
 * @Description
 * @Author 李策
 * @Date 2021-5-05 17:53
 */
@Controller
@RequestMapping("/consult")
public class ConsultController {
    @Autowired
    private ConsultantService consultantService;

    //获取疾病信息
    @RequestMapping("/show")
    private String showConsultant(Model model, HttpServletRequest request){
        //咨询医师对象合集
        List<Consultant> consultants = consultantService.getAll();
        //输出集合内容
        for(Consultant consultant:consultants){
            System.out.println(consultant.toString());
        }
        //获取集合大小
        System.out.println(consultants.size());
        model.addAttribute("consultants",consultants);
        return "other/show";
    }
}
