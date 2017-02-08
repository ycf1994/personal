package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tongniu.loan.role.domain.Operator;
import com.tongniu.loan.role.service.OperatorService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Resource
	private OperatorService operatorService;
	/**
	 * 登录页
	 */
	@RequestMapping(value = "/loginPage")
	public String loginPage() {
		return "admin/login";
	}

	/**
	 * 登入
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		if ("admin".equals(username) && "admin".equals(password)) {
			session.setAttribute("admin", username);
			return "admin/index";
		}
		Operator operator=operatorService.login(username, password);
		if(operator!=null){
			operatorService.update_login_time(operator.getId());
			session.setAttribute("operator", operator);
			return "admin/index";
		}
		return "admin/login";
	}

	/**
	 * 注销
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		session.removeAttribute("operator");
		return "admin/login";
	}

}
