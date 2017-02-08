package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.business.domain.Tstockinfo;
import com.tongniu.loan.business.service.ParameterService;
import com.tongniu.loan.business.service.TstockinfoService;

@Controller
@RequestMapping(value = "/admin/tstockinfo")
public class TstockinfoController {

	@Resource
	private TstockinfoService tstockinfoService;

	@Resource
	private ParameterService parameterService;

	@RequestMapping(value = "tstockinfo")
	public String tstockinfo() {
		return "admin/tstockinfo";
	}

	@RequestMapping(value = "/getAllTstockinfoList")
	@ResponseBody
	public String getAllTstockinfoList(int page, int rows, ModelMap map) {
		map.put("rows", tstockinfoService.getAllTstockinfoList(page, rows));
		map.put("total", tstockinfoService.getAllTstockinfoListCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/searchTstockinfo")
	@ResponseBody
	public String searchTstockinfo(int page, int rows, ModelMap map, String value) {
		map.put("rows", tstockinfoService.searchTstockinfo(value, page, rows));
		map.put("total", tstockinfoService.searchTstockinfoCount(value));
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/getAllNeedPara")
	@ResponseBody
	public String getAllNeedPara(int type_id) {
		return JSON.toJSONString(parameterService.getAllNeedPara(type_id));
	}

	@RequestMapping(value = "/addTstockinfo")
	@ResponseBody
	public String addTstockinfo(Tstockinfo tstockinfo, ModelMap map) {
		map.put("isAdded", tstockinfoService.addTstockinfo(tstockinfo));
		return JSON.toJSONString(map);
	}
	@RequestMapping(value = "/findStocks")
	@ResponseBody
	public String findStocks(String value) {
		return JSON.toJSONString(tstockinfoService.findStocks(value));
	}

}
