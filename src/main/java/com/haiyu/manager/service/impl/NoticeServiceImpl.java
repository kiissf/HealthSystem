package com.haiyu.manager.service.impl;

import com.haiyu.manager.dao.NoticeMapper;
import com.haiyu.manager.pojo.Notice;
import com.haiyu.manager.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName NoticeServiceImpl
 * @Description
 * @Author 李策
 * @Date 2021-3-03 23:03
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> getAll() {
        List<Notice> list =  noticeMapper.getAll();
        for(Notice notice:list){
            System.out.println(notice.toString());
        }
        return list;
    }
}
