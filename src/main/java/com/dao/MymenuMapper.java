package com.dao;

import java.util.List;

import com.model.Mymenu;

public interface MymenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(Mymenu record);

    int insertSelective(Mymenu record);

    Mymenu selectByPrimaryKey(String id);
    
    Mymenu selectById(String id);

    int updateByPrimaryKeySelective(Mymenu record);

    int updateByPrimaryKey(Mymenu record);
	
	List<Mymenu> selectAllMenu();
}