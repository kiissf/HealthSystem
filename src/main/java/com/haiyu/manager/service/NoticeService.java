package com.haiyu.manager.service;
import com.haiyu.manager.pojo.Notice;

import java.util.List;

/**
 * @ClassName NoticeService
 * @Description
 * @Author 李策
 * @Date 2021-3-03 23:01
 */
public interface NoticeService {
    List<Notice> getAll();

    Notice getById(int id);
}
