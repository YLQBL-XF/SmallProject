package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.MymenuMapper;
import com.httpModel.EasyuiTreeNode;
import com.model.Mymenu;
import com.model.User;
import com.service.MyMenuServiceI;
import com.service.UserServiceI;


public class test {

	 UserServiceI iuService;
	 MyMenuServiceI mymenuservice;
	 ApplicationContext ac;

	    @Before
	    public void before(){
	        ac=new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
	        iuService= (UserServiceI)ac.getBean("userServiceImpl");
	        mymenuservice=(MyMenuServiceI) ac.getBean("mymenuImpl");
	    }
	    
	    @Test
	    public void getUser(){
	        User user = iuService.findUserById(1);
	        System.out.println(user.getIdentity());
	    }
	    
	    @Test 
	    public void delUser(){
	        boolean byId = iuService.delById(1);
	        
	        System.out.println(byId);
	    }
	    
	    
	    
	    @Test
	    public void findAllUser(){
	    	List<User> lsus= iuService.findAll();
	    	
	    	System.out.println(lsus);
	    	List<EasyuiTreeNode> all = mymenuservice.findAll();
	    	List<EasyuiTreeNode> tree = new ArrayList<EasyuiTreeNode>();
//			tree.add(tree(selectByPrimaryKey, false));
	    	System.out.println(all.get(0).toString().toString());
	    }
	    
	    
	    @Test
	    public void updateUser(){
	    	iuService.updateUser(new User());
	    	
	    	System.out.println();
	    }
}
