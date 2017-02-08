package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.business.service.UserCarryService;

@Controller
@RequestMapping("/admin/userCarry")
public class UserCarryController {

	@Resource
	private UserCarryService userCarryService;

	@RequestMapping("/userCarry")
	public String userCarry() {
		return "admin/usercarry";
	}

	@RequestMapping("/findUserCarry")
	@ResponseBody
	public String findUserCarry(String searchValue, int status,int page, int rows, ModelMap map) {
		map.put("rows", userCarryService.findUserCarry_Rows(searchValue,status, page, rows));
		map.put("total", userCarryService.findUserCarry_Total(searchValue,status));
		return JSON.toJSONString(map);
	}
	@RequestMapping("/check")
	@ResponseBody
	public String check(int status, int id, ModelMap map) {
		map.put("msg", userCarryService.check(status, id));
		return JSON.toJSONString(map);
	}

}
