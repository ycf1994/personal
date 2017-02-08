package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.business.domain.Hqinfo;
import com.tongniu.loan.business.service.HqinfoService;

@Controller
@RequestMapping("/admin/hqinfo")
public class HqinfoController {

	@Resource
	private HqinfoService hqinfoService;

	@RequestMapping("/hqinfo")
	public String hqinfo() {
		return "admin/hqinfo";
	}

	@RequestMapping("/findHqinfoList")
	@ResponseBody
	public String findHqinfoList(String codeOrName, int hq_date, int page, int rows, ModelMap map) {
		map.put("rows", hqinfoService.findHqinfoList_Rows(codeOrName, hq_date, page, rows));
		map.put("total", hqinfoService.findHqinfoList_Total(codeOrName, hq_date));
		return JSON.toJSONString(map);
	}

	@RequestMapping("/find")
	@ResponseBody
	public String find(String stock_code, ModelMap map) {
		map.put("msg", hqinfoService.find(stock_code));
		return JSON.toJSONString(map);
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add(Hqinfo hqinfo, ModelMap map) {
		map.put("msg", hqinfoService.add(hqinfo));
		return JSON.toJSONString(map);
	}
	@RequestMapping("/update")
	@ResponseBody
	public String update(Hqinfo hqinfo, ModelMap map) {
		map.put("msg", hqinfoService.update(hqinfo));
		return JSON.toJSONString(map);
	}
}
