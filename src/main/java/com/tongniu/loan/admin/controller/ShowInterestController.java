package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.view.service.ShowInterestService;

@Controller
@RequestMapping(value = "/admin/showInterest")
public class ShowInterestController {

	@Resource
	private ShowInterestService showInterestService;

	@RequestMapping(value = "/showInterest")
	public String showInterest() {
		return "admin/showinterest";
	}

	@RequestMapping(value = "/getAllShowInterestList")
	@ResponseBody
	public String getShowInterestList(int page, int rows, ModelMap map) {
		map.put("rows", showInterestService.getAllShowInterestList(page, rows));
		map.put("total", showInterestService.getAllShowInterestListCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/searchShowInterest")
	@ResponseBody
	public String searchShowInterest(int page, int rows, String value, ModelMap map) {
		map.put("rows", showInterestService.searchShowInterest(page, rows, value));
		map.put("total", showInterestService.searchShowInterestCount(value));
		return JSON.toJSONString(map);
	}
}
