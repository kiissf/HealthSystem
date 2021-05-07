package com.haiyu.manager.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ConsultController
 * @Description
 * @Author 李策
 * @Date 2021-5-05 17:53
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    //获取月报告
    @RequestMapping("/month")
    private String showMonthReport(Model model, HttpServletRequest request) {


        return "report/month";
    }

    //获取月报告
    @RequestMapping("/year")
    private String showYearReport(Model model, HttpServletRequest request) {


        return "report/year";
    }

}

