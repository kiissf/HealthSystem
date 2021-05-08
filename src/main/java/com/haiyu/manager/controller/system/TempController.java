package com.haiyu.manager.controller.system;

import com.haiyu.manager.pojo.Temperature;
import com.haiyu.manager.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private String tempIndex(HttpSession session) {
        return "/temp/temp";
    }


    @RequestMapping("/add")
    private String tempAdd(Model model, HttpServletRequest request,HttpSession session) {
        //获取温度
        String heatAm = request.getParameter("heat_am");
        String heatPm = request.getParameter("heat_pm");
        System.out.println("提交温度: 上午温度-"+ heatAm + "下午温度-"+heatPm);

        //获取session存储的id值
        Integer stuId = (Integer) session.getAttribute("stuId");
        if(stuId!=null) {
            System.out.println(stuId);
        }
        //获取时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(date));
        String heatDate = format.format(date);
        //构建体温对象
        Temperature temperature = new Temperature();
        temperature.setHeat_am(Double.valueOf(heatAm));
        temperature.setHeat_pm(Double.valueOf(heatPm));
        temperature.setStudent_id(stuId);
        temperature.setDate(heatDate);
        System.out.println(temperature.toString());
        System.out.println("体温保存成功");
        //提交信息保存
        temperatureService.insertTemperature(temperature);
        return "temp/temp";

    }

    //初始化页面
    @RequestMapping("/month")
    private String month(Model model, HttpServletRequest request,HttpSession session){


        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM");
        System.out.println(format.format(date));
        String heatDate = format.format(date);
        List<Temperature> temperatures = temperatureService.findMonthTemp(heatDate);
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
    private String week(Model model, HttpServletRequest request,HttpSession session){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //获取今天周几
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (index < 0) index = 0;

        System.out.println("当前index的值为："+index);

        String monday = "";
        String sunday = "";
        Date date = null;
        switch (index){
            case 0:
                calendar.add(Calendar.DATE, - 7-6);
                date = calendar.getTime();
                monday = simpleDateFormat.format(date);

                calendar.add(Calendar.DATE, +6);
                date = calendar.getTime();
                sunday = simpleDateFormat.format(date);
                break;
            case 1:
                calendar.add(Calendar.DATE, - 7);
                date = calendar.getTime();
                monday = simpleDateFormat.format(date);

                calendar.add(Calendar.DATE, +6);
                date = calendar.getTime();
                sunday = simpleDateFormat.format(date);
                break;
            case 2:
                calendar.add(Calendar.DATE, - 7-1);
                date = calendar.getTime();
                monday = simpleDateFormat.format(date);

                calendar.add(Calendar.DATE, +6);
                date = calendar.getTime();
                sunday = simpleDateFormat.format(date);
                break;
            case 3:
                calendar.add(Calendar.DATE, - 7-2);
                date = calendar.getTime();
                monday = simpleDateFormat.format(date);

                calendar.add(Calendar.DATE, +6);
                date = calendar.getTime();
                sunday = simpleDateFormat.format(date);
                break;
            case 4:
                calendar.add(Calendar.DATE, - 7-3);
                date = calendar.getTime();
                monday = simpleDateFormat.format(date);

                calendar.add(Calendar.DATE, +6);
                date = calendar.getTime();
                sunday = simpleDateFormat.format(date);
                break;
            case 5:
                calendar.add(Calendar.DATE, - 7-4);
                date = calendar.getTime();
                monday = simpleDateFormat.format(date);
                calendar.add(Calendar.DATE, +6);
                date = calendar.getTime();
                sunday = simpleDateFormat.format(date);
                break;
            case 6:
                calendar.add(Calendar.DATE, - 7-5);
                date = calendar.getTime();
                monday = simpleDateFormat.format(date);
                calendar.add(Calendar.DATE, +6);
                date = calendar.getTime();
                sunday = simpleDateFormat.format(date);
                break;
        }
        System.out.println(monday+":"+sunday);

        List<Temperature> temperatures = temperatureService.findWeekTemp(monday,sunday);
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
