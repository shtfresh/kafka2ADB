package com.oracle.tao.service.impl;


import com.oracle.tao.dao.VideoJsonDao;
import com.oracle.tao.service.VideoJsonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VideoJsonServiceImpl implements VideoJsonService {

    @Resource
    private VideoJsonDao videoJsonDao;

    @Override
    public int create(String JsonData) {
        return videoJsonDao.create(JsonData);
    }

}
