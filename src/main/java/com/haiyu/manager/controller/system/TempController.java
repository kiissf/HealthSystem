package com.haiyu.manager.controller.system;

import com.haiyu.manager.pojo.Disease;
import com.haiyu.manager.pojo.Temperature;
import com.haiyu.manager.service.ConsultantService;
import com.haiyu.manager.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TempController
 * @Description
 * @Author 李策
 * @Date 2021-5-08 12:29
 */
@Controller
@RequestMapping("/temp")
public class TempController {
    //初始化页面
    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping("/temp")
    private String tempIndex(Model model, HttpServletRequest request) {

        return "/temp/temp";

    }


    @RequestMapping("/add")
    private String tempAdd(Model model, HttpServletRequest request) {
        //获取温度
        String heatAm = request.getParameter("heat_am");
        String heatPm = request.getParameter("heat_pm");
        System.out.println("提交温度: 上午温度-"+ heatAm + "下午温度-"+heatPm);

        //获取时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(date));
        String heatDate = format.format(date);
        //构建体温对象
        Temperature temperature = new Temperature();
        temperature.setHeat_am(Double.valueOf(heatAm));
        temperature.setHeat_pm(Double.valueOf(heatPm));
        temperature.setStudent_id(1);
        temperature.setDate(heatDate);
        System.out.println("体温保存成功");
        //提交信息保存
        return "temp/temp";

    }

    //初始化页面
    @RequestMapping("/month")
    private String month(Model model, HttpServletRequest request){
        List<Temperature> temperatures = temperatureService.getAll();
        //输出集合内容
        for(Temperature temperature:temperatures){
            System.out.println(temperature.toString());
        }
        //获取集合大小
        System.out.println(temperatures.size());
        model.addAttribute("temps",temperatures);
        return "temp/month";
    }

    //初始化页面
    @RequestMapping("/week")
    private String week(Model model, HttpServletRequest request){
        //疾病对象合集
        List<Temperature> temperatures = temperatureService.getAll();
        //输出集合内容
        for(Temperature temperature:temperatures){
            System.out.println(temperature.toString());
        }
        //获取集合大小
        System.out.println(temperatures.size());
        model.addAttribute("temps",temperatures);
        return "temp/week";
    }


}
