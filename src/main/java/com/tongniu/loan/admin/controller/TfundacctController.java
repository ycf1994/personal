package com.tongniu.loan.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.account.service.InvestmentAccountService;
import com.tongniu.loan.account.service.TfundacctService;
import com.tongniu.loan.business.service.ContractService;
import com.tongniu.loan.view.service.ShowContractService;

@Controller
@RequestMapping(value = "/admin/tfundacct")
public class TfundacctController {

	@Resource
	private TfundacctService tfundacctService;

	@Resource
	private ContractService contractService;

	@Resource
	private InvestmentAccountService investmentAccountService;
	
	@Resource
	private ShowContractService showContractService;

	@RequestMapping(value = "/tfundacct")
	public String tfundacct() {
		return "admin/tfundacct";
	}

	@RequestMapping(value = "/getTfundacctList")
	@ResponseBody
	public String getTfundacctList(int page, int rows, ModelMap map) {
		map.put("rows", tfundacctService.getTfundacctList(page, rows));
		map.put("total", tfundacctService.getTfundacctListCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/getTfundacctListByCust_name")
	@ResponseBody
	public String getTfundacctListByCust_name(int page, int rows, ModelMap map, String cust_name) {
		map.put("rows", tfundacctService.getTfundacctListByCust_name(page, rows, cust_name));
		map.put("total", tfundacctService.getTfundacctListByCust_nameCount(cust_name));
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/backMoney")
	@ResponseBody
	public String backMoney(String contract_no, Integer fund_id, Double contract_money, ModelMap map) {
		boolean flag = contractService.changeStateByBackMoney(contract_no);
		String investment_account_no = contractService.getInvestment_account_noByContract_no(contract_no);
		boolean flag2 = investmentAccountService.backMoney(investment_account_no, contract_money);
		boolean flag3 = tfundacctService.backMoney(fund_id, contract_money);
		map.put("msg", flag && flag2 && flag3);
		return JSON.toJSONString(map);

	}

	@RequestMapping(value = "/checkStockIsEmpty")
	@ResponseBody
	public String checkStockIsEmpty(int fund_id, ModelMap map) {
		map.put("isEmpty", tfundacctService.checkStockIsEmpty(fund_id));
		return JSON.toJSONString(map);
	}
	@RequestMapping(value = "/getContractsByFund_id")
	@ResponseBody
	public String getContractsByFund_id(int fund_id, int page, int rows, ModelMap map) {
		map.put("rows", showContractService.getShowContractsByFund_id(fund_id, page, rows));
		map.put("total", showContractService.getShowContractsByFund_id_Count(fund_id));
		return JSON.toJSONString(map);
	}
	@RequestMapping(value = "/fundacctBack")
	@ResponseBody
	public String fundacctBack(int fund_id, double money, String contract_no,ModelMap map){
		map.put("msg", tfundacctService.tfundacctBack(fund_id, money, contract_no));
		return JSON.toJSONString(map);
	}
}
