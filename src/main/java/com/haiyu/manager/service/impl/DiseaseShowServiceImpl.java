package com.haiyu.manager.service.impl;

import com.haiyu.manager.dao.DiseaseMapper;
import com.haiyu.manager.pojo.Disease;
import com.haiyu.manager.service.DiseaseService;
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
public class DiseaseShowServiceImpl  implements DiseaseService {
    @Autowired
    private DiseaseMapper diseaseMapper;
    @Override
    public List<Disease> getAll() {
        List<Disease> list =  diseaseMapper.getAll();
        for(Disease disease:list){
            System.out.println(disease.toString());
        }
        return list;
    }
}
