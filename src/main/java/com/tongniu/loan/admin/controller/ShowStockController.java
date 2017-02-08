package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.view.service.ShowSquaredataService;
import com.tongniu.loan.view.service.ShowStockamountService;

@Controller
@RequestMapping(value = "/admin/showStock")
public class ShowStockController {

	@Resource
	private ShowSquaredataService showSquaredataService;

	@RequestMapping(value = "/showStock")
	public String showStock() {
		return "admin/showstock";
	}

	@RequestMapping(value = "/getAllShowSquaredataList")
	@ResponseBody
	public String getAllShowSquaredataList(int page, int rows, ModelMap map) {
		
		map.put("rows", showSquaredataService.getAllShowSquaredataList(page, rows));
		map.put("total", showSquaredataService.getAllShowSquaredataListCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/searchShowSquaredata")
	@ResponseBody
	public String searchShowSquaredata(String cust_name, int page, int rows, ModelMap map) {
		
		map.put("rows", showSquaredataService.searchShowSquaredata(cust_name, page, rows));
		map.put("total", showSquaredataService.searchShowSquaredataCount(cust_name));
		return JSON.toJSONString(map);
	}
	
	@Resource
	private ShowStockamountService showStockamountService;
	
	@RequestMapping(value = "/getAllShowStockamountList")
	@ResponseBody
	public String getAllShowStockamountList(int page, int rows, ModelMap map) {
		
		map.put("rows", showStockamountService.getAllShowStockamountList(page, rows));
		map.put("total", showStockamountService.getAllShowStockamountListCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/searchShowStockamountCount")
	@ResponseBody
	public String searchShowStockamountCount(String cust_name, int page, int rows, ModelMap map) {
		
		map.put("rows", showStockamountService.searchShowStockamount(cust_name, page, rows));
		map.put("total", showStockamountService.searchShowStockamountCount(cust_name));
		return JSON.toJSONString(map);
	}
}
