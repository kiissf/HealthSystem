package com.haiyu.manager.service;

import com.haiyu.manager.pojo.Temperature;

import java.util.List;

/**
 * @ClassName DailyService
 * @Description
 * @Author 李策
 * @Date 2021-3-05 21:54
 */
public interface DailyService {
    void insertTemperature(Temperature temperature);

    List<Temperature> getAll();

    List<Temperature> getAllByStuId(int stuId);

}
