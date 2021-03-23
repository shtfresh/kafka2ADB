package com.oracle.tao.dao;

import org.apache.ibatis.annotations.Mapper;




    @Mapper
    public interface VideoJsonDao {
        public int create(String JsonData);

}
