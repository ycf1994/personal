package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.view.service.ShowUserCarryService;

@Controller
@RequestMapping("/admin/showUserCarry")
public class ShowUserCarryController {
	
	@Resource
	private ShowUserCarryService showUserCarryService;
	
	@RequestMapping("/findUserCarry")
	@ResponseBody
	public String findShowUserCarry(String searchValue, int status,int page, int rows, ModelMap map){
		map.put("rows", showUserCarryService.findShowUserCarry_Rows(searchValue, status, page, rows));
		map.put("total", showUserCarryService.findShowUserCarry_Total(searchValue, status));
		return JSON.toJSONString(map);
	}
}
