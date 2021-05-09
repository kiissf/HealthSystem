package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.HealthKnowledge;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

/**
 * @ClassName HealthKonwledgeDao
 * @Description
 * @Author 李策
 * @Date 2021-3-03 22:59
 */
@Repository
public interface HealthKnowledgeMapper extends MyMapper<HealthKnowledge> {

    List<HealthKnowledge> getAll();

    HealthKnowledge getById(int id);
}
