package com.haiyu.manager.service;

import com.haiyu.manager.pojo.Disease;

import java.util.List;

/**
 * @ClassName DiseaseShowService
 * @Description
 * @Author 李策
 * @Date 2021-3-01 21:58
 */
public interface DiseaseService {

    List<Disease> getAll();

    Disease getById(int id);

}
