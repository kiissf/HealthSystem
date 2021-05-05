package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.Notice;
import com.haiyu.manager.pojo.Temperature;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

/**
 * @ClassName NoticeDao
 * @Description
 * @Author 李策
 * @Date 2021-3-03 22:57
 */
@Repository
public interface NoticeMapper extends MyMapper<Notice> {

    List<Notice> getAll();
}
