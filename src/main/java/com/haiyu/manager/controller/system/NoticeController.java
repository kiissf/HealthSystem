package com.haiyu.manager.controller.system;

import com.haiyu.manager.pojo.Disease;
import com.haiyu.manager.pojo.Notice;
import com.haiyu.manager.service.DiseaseService;
import com.haiyu.manager.service.NoticeService;
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
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //获取疾病信息
    @RequestMapping("/show")
    private String showNotice(Model model, HttpServletRequest request){

        //疾病对象合集
        List<Notice> notices = noticeService.getAll();
        //输出集合内容
        for(Notice notice:notices){
            System.out.println(notice.toString());
        }
        //获取集合大小
        System.out.println(notices.size());
        model.addAttribute("notices",notices);
        return "information/show";
    }

}
