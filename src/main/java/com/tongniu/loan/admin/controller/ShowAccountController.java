package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.view.service.ShowAccountService;
@Controller
@RequestMapping(value = "admin/showAccount")
public class ShowAccountController {

	@Resource
	private ShowAccountService showAccountService;

	@RequestMapping(value = "/getAllShowAccount")
	@ResponseBody
	public String getAllShowAccount(ModelMap map, int page, int rows) {
		map.put("total", showAccountService.getAllShowAccountCount());
		map.put("rows", showAccountService.getAllShowAccount(page, rows));
		return JSON.toJSONString(map);
	}
	@RequestMapping(value = "/showAccount")
	public String showAccount(){
		return "admin/showaccount";
	}
	
	@RequestMapping(value = "/search")
	@ResponseBody
	public String search(ModelMap map, int page, int rows,String value) {
		map.put("total", showAccountService.getSearchCount(value));
		map.put("rows", showAccountService.searchAccount(page, rows, value));
		return JSON.toJSONString(map);
	}
	
}
