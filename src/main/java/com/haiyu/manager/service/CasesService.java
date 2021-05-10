package com.haiyu.manager.service;

import com.haiyu.manager.pojo.Cases;
import com.haiyu.manager.pojo.Temperature;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DiseaseShowService
 * @Description
 * @Author 李策
 * @Date 2021-3-01 21:58
 */
public interface CasesService {
    List<Cases> getAll();
    List<Cases> getAllByStuId(@Param("stuId") int stuId);
    boolean insertCases(Cases cases);
    List<Cases> getAllByManId(@Param("managerId") int managerId);
}
