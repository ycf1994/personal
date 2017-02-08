package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.role.domain.Operator;
import com.tongniu.loan.role.service.OperatorService;

@Controller
@RequestMapping("/admin/operator")
public class OperatorController {
	@Resource
	private OperatorService operatorService;

	@RequestMapping("/add")
	@ResponseBody
	public String add(Operator operator, ModelMap map) {
		map.put("msg", operatorService.add(operator));
		return JSON.toJSONString(map);
	}

	@RequestMapping("/update")
	@ResponseBody
	public String update(Operator operator, ModelMap map) {
		map.put("msg", operatorService.update(operator));
		return JSON.toJSONString(map);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(int id, ModelMap map) {
		map.put("msg", operatorService.delete(id));
		return JSON.toJSONString(map);
	}

	@RequestMapping("/find")
	@ResponseBody
	public String find(String value, int page, int rows, ModelMap map) {
		map.put("rows", operatorService.find_rows(value, page, rows));
		map.put("total", operatorService.find_count(value));
		return JSON.toJSONString(map);
	}

	@RequestMapping("/checkSame")
	@ResponseBody
	public String checkSame(String username, ModelMap map) {
		map.put("msg", operatorService.checkSame(username));
		return JSON.toJSONString(map);
	}

	@RequestMapping("/operator")
	public String operator() {
		return "admin/operator";
	}
}
