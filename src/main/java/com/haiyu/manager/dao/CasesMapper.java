package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.Cases;
import com.haiyu.manager.pojo.Temperature;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

/**
 * @ClassName DailyDao
 * @Description
 * @Author 李策
 * @Date 2021-3-05 18:03
 */

@Repository
public interface CasesMapper extends MyMapper<Cases> {
    List<Cases> getAll();
    List<Cases> getAllByStuId(@Param("stuId") int stuId);
    boolean insertCases(Cases cases);
}
