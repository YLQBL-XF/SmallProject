package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);		

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
    
    //shixiaohui add start  
    List<User> selectAll();
    
    User login(String name,String password);
    //shixiaohui add end    

	List findUserByParams(User user);
}