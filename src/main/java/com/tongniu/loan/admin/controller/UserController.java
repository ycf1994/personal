package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.role.domain.User;
import com.tongniu.loan.role.service.UserService;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/manage")
	public String manage() {
		return "admin/usermanage";
	}

	@RequestMapping(value = "/show",method=RequestMethod.POST)
	@ResponseBody
	public String show(ModelMap map, int page, int rows) {
		map.put("rows", userService.findUserByPageAndRow(page, rows));
		map.put("total", userService.getUserCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(Integer id, ModelMap map) {
		map.put("msg", userService.delUser(id));
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(User user, ModelMap map) {
		map.put("msg", userService.updateUser(user));
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(User user, ModelMap map) {
		map.put("msg", userService.addUser(user));
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public String search(String value, ModelMap map, int page, int rows) {
		map.put("rows", userService.searchUser(value, page, rows));
		map.put("total", userService.searchUserCount(value));
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/checkMobile", method = RequestMethod.POST)
	@ResponseBody
	public String checkMobile(String phone, ModelMap map) {
		map.put("msg", userService.getMobileCount(phone));
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "checkSameUsername", method = RequestMethod.POST)
	@ResponseBody
	public String checkSameUsername(String username, ModelMap map) {
		System.out.println(userService.getIdByUsername(username)==null);
		map.put("msg", userService.getIdByUsername(username) == null);
		return JSON.toJSONString(map);
	}

}
