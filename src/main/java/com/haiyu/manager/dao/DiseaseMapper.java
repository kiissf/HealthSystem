package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.Disease;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

/**
 * @ClassName DiseaseShowDao
 * @Description
 * @Author 李策
 * @Date 2021-3-01 21:48
 */
@Repository
public interface DiseaseMapper extends MyMapper<Disease> {

    List<Disease> getAll();

    Disease getById(int id);
}
