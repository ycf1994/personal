package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.role.domain.Cust;
import com.tongniu.loan.role.service.CustService;

@Controller
@RequestMapping(value = "/admin/cust")
public class CustController {
	@Resource
	private CustService custService;

	@RequestMapping(value = "/cust")
	public String cust() {
		return "admin/cust";
	}

	@RequestMapping(value = "getCustList")
	@ResponseBody
	public String getCustList(int page, int rows, ModelMap map) {

		map.put("rows", custService.getCustList(page, rows));
		map.put("total", custService.getCustLsitCount());
		return JSON.toJSONString(map);

	}
	@RequestMapping(value = "searchCust")
	@ResponseBody
	public String searchCust(int page, int rows, ModelMap map,String realname){
		map.put("rows", custService.searchCust(page, rows, realname));
		map.put("total", custService.searchCustCount(realname));
		return JSON.toJSONString(map);
	}
	@RequestMapping(value = "addCust")
	@ResponseBody
	public String addCust(Cust cust,ModelMap map){
		map.put("msg", custService.addCust(cust));
		return JSON.toJSONString(map);
	}
}
