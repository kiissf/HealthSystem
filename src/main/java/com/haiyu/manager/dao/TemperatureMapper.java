package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.Notice;
import com.haiyu.manager.pojo.Temperature;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

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
}
