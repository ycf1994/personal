package com.tongniu.loan.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tongniu.loan.role.domain.User;
import com.tongniu.loan.role.service.UserService;

@Controller("/user/log")
public class LogController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/doLogin")
	public String doLogin(String mobile,String password,HttpSession session){
		User token=userService.doLogin(mobile, password);
		if(token!=null){
			session.setAttribute("token", token);
			return "my.html";
		}else{
			return "login.html";
		}
	}
}
