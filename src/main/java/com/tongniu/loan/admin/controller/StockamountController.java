package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.business.service.StockamountService;

@Controller
@RequestMapping(value = "/admin/stockamount")
public class StockamountController {

	@Resource
	private StockamountService stockamountService;

	@RequestMapping(value = "/searchStockamount")
	@ResponseBody
	public String searchStockamount(Integer fund_id, int page, int rows, ModelMap map) {
		
		map.put("rows", stockamountService.searchStockamout(fund_id, page, rows));
		map.put("total", stockamountService.searchStockamoutCount(fund_id));
		return JSON.toJSONString(map);
	}
}
