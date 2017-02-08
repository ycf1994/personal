package com.tongniu.loan.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.account.service.TfundacctService;
import com.tongniu.loan.business.domain.Contract;
import com.tongniu.loan.business.service.ContractService;
import com.tongniu.loan.business.service.FlowService;
import com.tongniu.loan.role.domain.Operator;

@Controller
@RequestMapping(value = "/admin/contract")
public class ContractController {
	@Resource
	private ContractService contractService;

	@Resource
	private TfundacctService tfundacctService;

	@Resource
	private FlowService flowService;

	@RequestMapping(value = "/checkContract", method = RequestMethod.POST)
	@ResponseBody
	public String checkContract(String contract_no, Integer states, ModelMap map,HttpSession session) {
		int s=states;
		Contract contract = contractService.getContractByContract_no(contract_no);
		// contract.setContract_no(contract_no);
		if(states==7) states=1;
		contract.setStates(states);
		if(session.getAttribute("admin")!=null)
		contract.setCheck_name("admin");
		else
			contract.setCheck_name(((Operator)session.getAttribute("operator")).getRealname());

		contract.setCheck_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		boolean flag = contractService.updateStates(contract);

		if (s == 7) {
			map.put("msg", flag
					&& tfundacctService.cancelBack(contract.getFund_id(), contract.getContract_money(), contract_no));
			return JSON.toJSONString(map);
		}

		if (states != 1) {
			if (states == 4) {
				map.put("msg", flag && contractService.zuofeihuikuan(contract_no));
			} else
				if(states==6){
				map.put("msg", flag&&contractService.querenhuikuan(contract_no)&&contractService.rateToaccountInsertFlow(contract_no));	
				}else
				map.put("msg", flag);
		} else {

			map.put("msg",
					flag && flowService.addContractFlow(contract.getUser_id(), contract.getContract_money())
							&& tfundacctService.addTfundacct(contract.getFund_id(), contract.getFund_acc(),
									contract.getCust_id(), contract_no, contract.getContract_money(),contract.getSum_money()));

		}
		// map.put("contract", contract);
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/searchContract")
	@ResponseBody
	public String searchContract(String investment_account_no, int page, int rows, ModelMap map) {
		map.put("rows", contractService.searchContract(investment_account_no, page, rows));
		map.put("total", contractService.searchContractCount(investment_account_no));
		return JSON.toJSONString(map);
	}
	@RequestMapping(value = "/checkSameContract_no")
	@ResponseBody
	public String checkSameContract_no(String contract_no,ModelMap map){
		map.put("msg", contractService.checkSameContract_no(contract_no));
		return JSON.toJSONString(map);
	}

}