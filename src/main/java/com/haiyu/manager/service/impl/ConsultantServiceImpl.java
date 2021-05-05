package com.haiyu.manager.service.impl;

import com.haiyu.manager.dao.ConsultantDao;
import com.haiyu.manager.pojo.Consultant;
import com.haiyu.manager.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ConsultantServiceImpl
 * @Description
 * @Author 李策
 * @Date 2021-3-03 23:02
 */
@Service
public class ConsultantServiceImpl implements ConsultantService {
    @Autowired
    private ConsultantDao dao;
    @Override
    public List<Consultant> getAll() {
        List<Consultant> list =  dao.getAll();
        return list;
    }
}
