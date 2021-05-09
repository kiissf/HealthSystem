package com.haiyu.manager.controller.system;

import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    private String caseLoad(Model model, HttpServletRequest request, MultipartFile file) throws IOException {

        //文件名称
        String realFileName = file.getOriginalFilename();
        System.out.println(realFileName);
        //文件后缀
        String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1);
        /***************文件处理*********************/

        // 将获取的json数据封装一层，然后在给返回
        String str = System.getProperty("user.dir") +"/src/main/resources/static/case/";
        file.transferTo(new File(str+ realFileName));



        System.out.println(str);
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "ResponseBody");
        JSONObject img = new JSONObject();
        img.put("src","");
        result.put("data", img);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.toJSONString();

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
