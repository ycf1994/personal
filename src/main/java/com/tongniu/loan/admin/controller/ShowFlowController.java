package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.view.service.ShowFlowService;

@Controller
@RequestMapping(value = "/admin/showFlow")
public class ShowFlowController {

	@Resource
	private ShowFlowService showFlowService;

	@RequestMapping(value = "/getAllShowFlowList")
	@ResponseBody
	public String getAllShowFlowList(int page, int rows, ModelMap map) {
		map.put("rows", showFlowService.getAllShowFlowList(page, rows));
		map.put("total", showFlowService.getAllShowFlowListCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/searchShowFlow")
	@ResponseBody
	public String searchShowFlow(String value, int flag, int page, int rows, ModelMap map) {
	
		map.put("rows", showFlowService.searchShowFlow(value, flag, page, rows));
		map.put("total", showFlowService.searchShowFlowCount(value, flag));
		return JSON.toJSONString(map);
	}
	@RequestMapping(value = "/showFlow")
	public String showflow() {
		
		return "admin/showflow";
	}

}
