package com.haiyu.manager.service.impl;

import com.haiyu.manager.dao.DailyMapper;
import com.haiyu.manager.pojo.Temperature;
import com.haiyu.manager.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DailyServiceImpl
 * @Description
 * @Author 李策
 * @Date 2021-3-05 21:55
 */
@Service
public class DailyServiceImpl implements DailyService {

    @Autowired
    private DailyMapper dailyMapper;

    @Override
    public void insertTemperature(Temperature temperature) {
        dailyMapper.insert(temperature);
    }

    @Override
    public List<Temperature> getAll() {
        List<Temperature> list = dailyMapper.getAll();
        for(Temperature temperature:list){
            System.out.println(temperature.toString());
        }
        return list;
    }

    @Override
    public List<Temperature> getAllByStuId(int stuId) {

        List<Temperature> list = dailyMapper.getAllByStuId(stuId);

        return list;
    }


}
