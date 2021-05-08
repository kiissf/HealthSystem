package com.haiyu.manager.service.impl;

import com.haiyu.manager.dao.DiseaseMapper;
import com.haiyu.manager.dao.TemperatureMapper;
import com.haiyu.manager.pojo.Disease;
import com.haiyu.manager.pojo.Temperature;
import com.haiyu.manager.service.DiseaseService;
import com.haiyu.manager.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DiseaseShowServiceImpl
 * @Description
 * @Author 李策
 * @Date 2021-3-01 21:59
 */
@Service
public class TempteratureServiceImpl implements TemperatureService {
    @Autowired
    private TemperatureMapper temperatureMapper;
    @Override
    public List<Temperature> getAll() {
        List<Temperature> list =  temperatureMapper.getAll();
        for(Temperature temperature:list){
            System.out.println(temperature.toString());
        }
        return list;
    }
}
