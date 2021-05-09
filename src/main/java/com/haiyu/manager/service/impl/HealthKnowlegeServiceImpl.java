package com.haiyu.manager.service.impl;

import com.haiyu.manager.dao.HealthKnowledgeMapper;
import com.haiyu.manager.pojo.HealthKnowledge;
import com.haiyu.manager.service.HealthKnowlegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HealthKnowlegeServiceImpl
 * @Description
 * @Author 李策
 * @Date 2021--03 23:03
 */
@Service
public class HealthKnowlegeServiceImpl implements HealthKnowlegeService {
    @Autowired
    private HealthKnowledgeMapper konwledgeMapper;

    @Override
    public List<HealthKnowledge> getAll() {
        List<HealthKnowledge> list = konwledgeMapper.getAll();
        for (HealthKnowledge healthKnowledge : list) {
            System.out.println(healthKnowledge.toString());
        }
        return list;
    }

    @Override
    public HealthKnowledge getById(int id) {
        HealthKnowledge data = konwledgeMapper.getById(id);
        return data;
    }
}
