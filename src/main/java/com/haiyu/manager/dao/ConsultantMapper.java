package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.Consultant;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

/**
 * @ClassName ConsultantDao
 * @Description
 * @Author 李策
 * @Date 2021-3-03 22:56
 */
@Repository
public interface ConsultantMapper extends MyMapper<Consultant> {

    List<Consultant> getAll();

}
