package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.pojo.Notice;
import com.haiyu.manager.pojo.Temperature;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.Date;
import java.util.List;

/**
 * @ClassName TemperatureMapper
 * @Description
 * @Author 李策
 * @Date 2021-5-08 13:38
 */
@Repository
public interface TemperatureMapper extends MyMapper<Temperature> {
    List<Temperature> getAll();
    boolean insertTemperature(Temperature temperature);
    List<Temperature> findWeekTemp(String monday,String sunday);
    //年+月
    List<Temperature> findMonthTemp(String date);
}
