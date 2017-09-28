package com.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.common.PageInfo;
import com.dao.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.model.User;
import com.service.UserServiceI;
@Service("userServiceImpl")
public class UserServiceImpl implements UserServiceI {

	 Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	/**********************************************************************/
	private UserMapper uMapper;
	
	public UserMapper getuMapper() {
		return uMapper;
	}

	@Autowired
	public void setuMapper(UserMapper uMapper) {
		this.uMapper = uMapper;
	}
	/**********************************************************************/
//	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			count = uMapper.insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int counts= uMapper.insert(user);
		if (count>0) {
			return true;
		}else{
			return false;
		}
	}

//	@Override
	public boolean delById(Integer id) {
		// TODO Auto-generated method stub
		int count = uMapper.deleteByPrimaryKey(id);
		
		if (count>0) {
			return true;
		}else{
			return false;
		}
	}

//	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		int count = uMapper.updateByPrimaryKey(user);
		
		if (count>0) {
			return true;
		}else{
			return false;
		}
	}

//	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		User user = uMapper.selectByPrimaryKey(id);
		return user;
	}

//	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> lsus = uMapper.selectAll();
		return lsus;
	}

	public User login(String name,String password) {
		// TODO Auto-generated method stub
		User us = uMapper.login(name,password);
		if (us != null) {
//			BeanUtils.copyProperties(us, us);
			return us;
		}
		return null;
	}

	
	
	@Override
	public void findUser(PageInfo pageInfo, User user,int rows) {
		// TODO Auto-generated method stub
		logger.info("findUser pageInfo:"+ JSON.toJSONString(pageInfo));
		logger.info("pageInfo.getPage()=="+pageInfo.getPage());
		logger.info("pageInfo.getRows()=="+pageInfo.getRows()); 
		
        Page<?> page = PageHelper.startPage(pageInfo.getPage(),rows);
        pageInfo.setRows(uMapper.findUserByParams(user));
        pageInfo.setTotal(page.getTotal());
	}

}
