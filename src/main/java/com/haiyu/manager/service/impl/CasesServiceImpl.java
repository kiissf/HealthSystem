package com.haiyu.manager.service.impl;

import com.haiyu.manager.dao.CasesMapper;
import com.haiyu.manager.dao.TemperatureMapper;
import com.haiyu.manager.pojo.Cases;
import com.haiyu.manager.pojo.Temperature;
import com.haiyu.manager.service.CasesService;
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
public class CasesServiceImpl implements CasesService {
    @Autowired
    private CasesMapper casesMapper;
    @Override
    public List<Cases> getAll() {
        List<Cases> list =  casesMapper.getAll();
        for(Cases cases:list){
            System.out.println(cases.toString());
        }
        return list;
    }

    @Override
    public List<Cases> getAllByStuId(int stuId) {
        List<Cases> list = casesMapper.getAllByStuId(stuId);
        for(Cases cases:list){
            System.out.println(cases.toString());
            System.out.println(cases.getStudent_id());

        }
        return list;
    }

    @Override
    public boolean insertCases(Cases cases) {
        boolean result = casesMapper.insertCases(cases);
        System.out.println("插入结果："+ result);
        return result;
    }

    @Override
    public List<Cases> getAllByManId(int managerId) {
        List<Cases> list = casesMapper.getAllByManId(managerId);
        for(Cases cases:list){
            System.out.println(cases.toString());
            System.out.println(cases.getStudent_id());

        }
        return list;
    }
}
