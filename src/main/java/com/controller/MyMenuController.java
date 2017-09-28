package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.httpModel.EasyuiTreeNode;
import com.httpModel.httpModeMenu;
import com.model.Mymenu;
import com.service.MyMenuServiceI;

@Controller
@RequestMapping("myMenuController")
public class MyMenuController {
	
	@Autowired
	private MyMenuServiceI myMenuServiceI;
	
	
	@RequestMapping("gettree")
	@ResponseBody
	public List<EasyuiTreeNode> getAllMenu(String id){
		if (id==null) {
			System.out.println("AAA");
			return myMenuServiceI.findAll();
		}else{
			System.out.println("BBB");
			return myMenuServiceI.findById(id);
		}
	}
	
	/**
	 * 获取菜单treegrid
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(params = "treegrid")
	@ResponseBody
	public List<httpModeMenu> treegrid(String id) {
		return myMenuServiceI.treegrid(id);
	}
}
