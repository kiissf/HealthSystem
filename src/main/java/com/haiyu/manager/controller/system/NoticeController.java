package com.haiyu.manager.controller.system;

import com.haiyu.manager.pojo.Notice;
import com.haiyu.manager.response.PageDataResult;
import com.haiyu.manager.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("/noticeManager")
    private String noticeManger() {
        return "information/showinfo";
    }

    @RequestMapping("/noticeshow")
    private String noticeShow() {
        return "information/noticedetail";
    }

    //获取疾病信息
    @RequestMapping("/show")
    @ResponseBody
    private PageDataResult showNotice(Model model, HttpServletRequest request) {
        PageDataResult pdr = new PageDataResult();
        List<Notice> notices = noticeService.getAll();
        //输出集合内容
        for (Notice notice : notices) {
            System.out.println(notice.toString());
        }
        pdr.setCode(200);
        pdr.setTotals(notices.size());
        pdr.setList(notices);
        return pdr;
    }


    @RequestMapping(value = "/showNotice")
    @ResponseBody
    public int setSessNotice(int id, HttpSession session) {
        int flag = 0;
        Notice notice = noticeService.getById(id);
        if (notice != null) {
            flag = 1;
            session.setAttribute("sessNotice", notice);
        }
        return flag;
    }

}
