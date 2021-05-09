package com.haiyu.manager.service;
import com.haiyu.manager.pojo.HealthKnowledge;

import java.util.List;

/**
 * @ClassName HealthKnowlegeService
 * @Description
 * @Author 李策
 * @Date 2021-3-03 23:01
 */
public interface HealthKnowlegeService {
    List<HealthKnowledge> getAll();

    HealthKnowledge getById(int id);
}
