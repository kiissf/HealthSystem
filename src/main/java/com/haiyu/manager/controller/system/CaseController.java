package com.haiyu.manager.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CaseController
 * @Description
 * @Author 李策
 * @Date 2021-5-08 12:29
 */

@Controller
@RequestMapping("/case")
public class CaseController {

    //初始化页面
    @RequestMapping("/case")
    private String caseSubmit(Model model, HttpServletRequest request) {
        return "/case/case";
    }

    //初始化页面
    @RequestMapping("/record")
    private String caseRecord(Model model, HttpServletRequest request) {
        return "/case/record";
    }

    //初始化页面
    @RequestMapping("/check")
    private String caseCheck(Model model, HttpServletRequest request) {
        return "/case/check";
    }

}
