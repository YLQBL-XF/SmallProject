package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.PageInfo;
import com.httpModel.Json;
import com.httpModel.ResultJson;
import com.httpModel.SessionInfo;
import com.model.User;
import com.service.UserServiceI;
import com.utils.IpUtil;
import com.utils.ResourceUtil;

@Controller
@RequestMapping("userController")
public class UserController {

	@Autowired
	private UserServiceI uServiceI;
	
	/*****************************查找单个用户**************************************/
	@RequestMapping("getUser/{id}")
	@ResponseBody
	public User getUser(@PathVariable Integer id,HttpServletRequest request){
		User user = uServiceI.findUserById(id);
		request.setAttribute("user", user);
		System.out.println(user.toString());
		return user;
	}
	
	/*****************************查找所有的用户**************************************/
	
	@RequestMapping("getAllUser")
	@ResponseBody
	public List<User> getAllUser(HttpServletRequest request){
		List<User> lsus = uServiceI.findAll();
		request.setAttribute("lsus", lsus);
		System.out.println(lsus);
		return lsus;
	}

	
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST},produces="text/html;charset=UTF-8")
    @ResponseBody
    public PageInfo<?> findUser(PageInfo<?> pageInfo, User user,int rows) {
		uServiceI.findUser(pageInfo, user ,rows);
        return pageInfo;
    }
	/******************************删除指定用户****************************************/
	@RequestMapping("delUser/{id}")
	@ResponseBody
	public boolean delUser(@PathVariable Integer id,HttpServletRequest request){
		boolean debl = uServiceI.delById(id);
		request.setAttribute("debl", debl);
		System.out.println(debl);
		return debl;
	}
	
	/******************************添加用户******************************************/
	@RequestMapping("addUser")
	@ResponseBody
	public boolean addUser(User user,HttpServletRequest request){
		System.out.println("==");
		boolean addbl = uServiceI.add(user);
		request.setAttribute("addbl", addbl);
		System.out.println(addbl);
		return true;
	}
	
	/******************************更新用户******************************************/
	@RequestMapping("updateUser")
	@ResponseBody
	public boolean updateUser(User user,HttpServletRequest request){
		boolean upbl = uServiceI.updateUser(user);
		request.setAttribute("addbl", upbl);
		System.out.println(upbl);
		return true;
	}

	/*****************************初始化界面******************************************/
	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		System.out.println(request.getContextPath());
		return "index";
	}
	@RequestMapping("home")
	public String homePage(HttpServletRequest request) {
		System.out.println(request.getContextPath());
		return "/WEB-INF/jsp/home";
	}
	
	@RequestMapping(params ="north")
	public String north() {
		System.out.println(2222);
		return "/layout/north";
	}

	@RequestMapping(params ="west")
	public String west() {
		System.out.println(333);
		return "/layout/west";
	}

	@RequestMapping(params = "center")
	public String center() {
		System.out.println(444);
		return "/layout/center";
	}

	@RequestMapping(params ="south")
	public String south() {
		System.out.println(555);
		return "/layout/south";
	}
	
	@RequestMapping(params ="authmsg")
	public String authMsg() {
		System.out.println("authmsg--->登录失败");
		return "/error/authMsg";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public ResultJson login(String name,String password,HttpSession session, HttpServletRequest request){
		System.out.println("login");
		ResultJson rj = new ResultJson();
		User u = uServiceI.login(name,password);
		if (u != null) {
			rj.setSuccess(true);
			rj.setMsg("登录成功!"); 

			u.setIp(IpUtil.getIpAddr(request));
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setUser(u);
			session.setAttribute(ResourceUtil.getSessionInfoName(), sessionInfo);
//			session.setAttribute("name", name); 
			rj.setObj(u);
		} else {
			rj.setMsg("用户名或密码错误!");
		}	
		return rj;
	}
	
	
	/**
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "logout")
	@ResponseBody
	public Json logout(HttpSession session) {
		Json j = new Json();
		if (session != null) {
			session.invalidate();
		}
		j.setSuccess(true);
		return j;
	}
}
