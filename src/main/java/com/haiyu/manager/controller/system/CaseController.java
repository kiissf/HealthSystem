package com.haiyu.manager.controller.system;

import com.haiyu.manager.pojo.Cases;
import com.haiyu.manager.service.CasesService;
import net.minidev.json.JSONObject;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName CaseController
 * @Description
 * @Author 李策
 * @Date 2021-5-08 12:29
 */

@Controller
@RequestMapping("/case")
public class CaseController {

    @Autowired
    private CasesService casesService;

    //初始化页面
    @RequestMapping("/case")
    private String caseSubmit() {
        return "/case/case";
    }

    //初始化页面
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    private String caseLoad(MultipartFile file, HttpSession session) throws IOException {

        //文件名称
        String realFileName = file.getOriginalFilename();
        System.out.println(realFileName);
        //文件后缀
        //String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1);
        //保存图片到static/case/文件夹下
        // 将获取的json数据封装一层，然后在给返回
        String str = System.getProperty("user.dir") +"/src/main/resources/static/case/";
        file.transferTo(new File(str+ realFileName));
        System.out.println(str);
        //发送前端json格式的数据
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "ResponseBody");
        JSONObject img = new JSONObject();
        img.put("src","");
        result.put("data", img);
        try {
            //获取studentId
            Integer id = (Integer) session.getAttribute("stuId");
            Cases cases = new Cases();
            cases.setStudent_id(id);
            cases.setPicture("/case/"+realFileName);
            casesService.insertCases(cases);


            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.toJSONString();

    }

    //初始化页面
    @RequestMapping("/record")
    private String caseRecord(Model model, HttpServletRequest request,HttpSession session) {
        //获取studentId
        Integer id = (Integer) session.getAttribute("stuId");
        List<Cases> casesList = casesService.getAllByStuId(id);
        request.setAttribute("casesList",casesList);

        return "/case/record";
    }

    //初始化页面
    @RequestMapping("/check")
    private String caseCheck(Model model, HttpServletRequest request) {
        return "/case/check";
    }

}
