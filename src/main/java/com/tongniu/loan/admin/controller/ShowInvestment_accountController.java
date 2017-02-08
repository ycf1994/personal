package com.tongniu.loan.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.account.domain.InvestmentAccount;
import com.tongniu.loan.account.service.InvestmentAccountService;
import com.tongniu.loan.role.domain.User;
import com.tongniu.loan.role.service.UserService;
import com.tongniu.loan.view.service.ShowInvestment_accountService;

@Controller
@RequestMapping(value="/admin/showInvestment_account")
public class ShowInvestment_accountController {
	
	@Resource
	private ShowInvestment_accountService showInvestment_accountService;
	
	@Resource
	private UserService userSerivce;

	@Resource
	private InvestmentAccountService investmentAccountService;
	
	
	
	@RequestMapping(value="/showInvestment_account")
	public String showInvestment_account(){
		return "admin/showInvestment_account";
	}
	
	@RequestMapping(value="/getAllShowInvestment_accountList")
	@ResponseBody
	public String getAllShowInvestment_accountList(int page,int rows,ModelMap map){
		map.put("rows", showInvestment_accountService.getAllShowInvestment_accountList(page, rows));
		map.put("total", showInvestment_accountService.getAllShowInvestment_accountListCount());
		return JSON.toJSONString(map);
	}
	@RequestMapping(value="/searchShowInvestment_account")
	@ResponseBody
	public String searchShowInvestment_account(String value,int page,int rows,ModelMap map){
		
		map.put("rows", showInvestment_accountService.searchShowInvestment_account(value, page, rows));
		map.put("total", showInvestment_accountService.searchShowInvestment_accountCount(value));
		return JSON.toJSONString(map);
				
	}
	@RequestMapping(value="/findUsers")
	@ResponseBody
	public String findUsers(){
		List<User> userList=userSerivce.findUser();
		
		return (JSON.toJSONString(userList));
	}
	

	
	
	/**
	 * 投资
	 */
	@RequestMapping(value = "/addInvestment_account", method = RequestMethod.POST)
	@ResponseBody
	public String addInvestmentAccount(InvestmentAccount investmentAccount, ModelMap map) {
		//investmentAccount.setInvestment_account_no(String.valueOf(System.currentTimeMillis()));
		long time=Long.valueOf(new SimpleDateFormat("yyMMddHHmmss").format(new Date()));
		if(!investmentAccountService.checkInvestment_account_no(investmentAccount.getUser_id()+"_"+time)){
			time+=1;
		}
		investmentAccount.setInvestment_account_no(investmentAccount.getUser_id()+"_"+time);
		//System.out.println(investmentAccount.getMoney());
		map.put("msg", investmentAccountService.addInvestmentAccount(investmentAccount));
		return JSON.toJSONString(map).toString();
	}
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		System.out.println(sdf.format(new Date()));
	}
	
}
