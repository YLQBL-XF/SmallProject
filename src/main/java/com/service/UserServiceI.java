package com.service;

import java.util.List;

import com.common.PageInfo;
import com.httpModel.ResultJson;
import com.model.User;


public interface UserServiceI {

	public boolean add(User user);

	public boolean delById(Integer id);

	public boolean updateUser(User user);
	
	public User findUserById(Integer id);
	
	public List<User> findAll();
	
	public User login(String name,String password);

	public void findUser(PageInfo pageInfo, User user,int rows);
}
