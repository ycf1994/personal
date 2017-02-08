package com.tongniu.loan.admin.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.tongniu.loan.account.service.TfundacctService;
import com.tongniu.loan.business.domain.Contract;
import com.tongniu.loan.business.service.ContractService;
import com.tongniu.loan.role.service.CustService;
import com.tongniu.loan.role.service.UserService;
import com.tongniu.loan.view.service.ShowContractService;

@Controller
@RequestMapping("/admin/showContract")
public class ShowContractController {
	@Resource
	private TfundacctService tfundacctService;
	@Resource
	private ShowContractService showContractService;

	@Resource
	private CustService custService;

	@Resource
	private InvestmentAccountService investmentAccountService;

	@Resource
	private UserService userService;

	@Resource
	private ContractService contractService;

	@RequestMapping(value = "/showContract")
	public String showContract() {
		return "admin/showcontract";
	}

	@RequestMapping(value = "getAllShowContractList")
	@ResponseBody
	public String getAllShowContractList(int page, int rows, ModelMap map) {
		map.put("rows", showContractService.getAllShowContractList(page, rows));
		map.put("total", showContractService.getAllShowContractListCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "searchShowContract")
	@ResponseBody
	public String searchShowContract(int page, int rows, ModelMap map, String user, String cust) {
		map.put("rows", showContractService.searchShowContract(page, rows, user, cust));
		map.put("total", showContractService.searchShowContractCount(user, cust));
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "checkContract")
	public String checkContract() {
		return "admin/checkcontract";
	}

	@RequestMapping(value = "getAllUncheckedShowContractList")
	@ResponseBody
	public String getAllUncheckedShowContractList(int page, int rows, ModelMap map) {
		map.put("rows", showContractService.getAllUncheckedShowContractList(page, rows));
		map.put("total", showContractService.getAllUncheckedShowContractListCount());
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/getAllCustList")
	@ResponseBody
	public String getAllCustList() {
		return JSON.toJSONString(custService.getAllCustList());
	}

	@RequestMapping(value = "/getInvestmentAccountsByUsername")
	@ResponseBody
	public String getInvestmentAccountsByUsername(String username, ModelMap map) {
		Integer id = userService.getIdByUsername(username);
		if (id == null) {
			map.put("msg", "IDNULL");
			return JSON.toJSONString(map);
		}

		List<InvestmentAccount> list = investmentAccountService.getInvestmentAccountsByUser_id(id);
		if (list.size() == 0) {
			map.put("msg", "InvestmentAccountNULL");
			return JSON.toJSONString(map);
		}
		map.put("id", id);
		map.put("msg", "success");
		map.put("list", list);
		return JSON.toJSONString(map);

	}

	@RequestMapping(value = "/getInvestmentAccountsByUser_id")
	@ResponseBody
	public String getInvestmentAccountsByUser_id(Integer user_id, ModelMap map) {
		/*
		 * Integer id = userService.getIdByUsername(username); if (id == null) {
		 * map.put("msg", "IDNULL"); return JSON.toJSONString(map); }
		 */

		List<InvestmentAccount> list = investmentAccountService.getInvestmentAccountsByUser_id(user_id);
		if (list.size() == 0) {
			map.put("msg", "InvestmentAccountNULL");
			return JSON.toJSONString(map);
		}
		// map.put("id", id);
		map.put("msg", "success");
		map.put("list", list);
		return JSON.toJSONString(map);

	}

	/**
	 * 录入合同
	 */
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	@ResponseBody
	public String inputContract(Contract contract, ModelMap map) {
		if (!showContractService.checkStart_date(contract.getInvestment_account_no(), contract.getStart_date())) {
			map.put("error", "error");
			return JSON.toJSONString(map);
		}

		contract.setFund_id(Math.abs((int) System.currentTimeMillis()));

		contract.setInvert_gain(countInvestGain(contract));
		// contract.setContract_no("con" + System.currentTimeMillis());
		String fund_id = tfundacctService.checkSame(contract.getCust_id(), contract.getFund_acc());
		if (fund_id != null)
			contract.setFund_id(Integer.valueOf(fund_id));
		map.put("isInputed", contractService.addContract(contract));
		return JSON.toJSONString(map).toString();
	}

	/**
	 * 计算预期收益
	 */
	private Double countInvestGain(Contract contract) {

		int days = 0;
		try {
			String start_date = contract.getStart_date();
			String end_date = contract.getEnd_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date start = sdf.parse(start_date);
			Date end = sdf.parse(end_date);
			days = daysBetween(start, end);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DecimalFormat formater = new DecimalFormat();
		formater.setMaximumFractionDigits(2);
		formater.setGroupingSize(0);
		formater.setRoundingMode(RoundingMode.FLOOR);

		return Double.valueOf(formater.format(contract.getInvestment_rate() * contract.getContract_money() / 365))
				* days;
	}

	/**
	 * 两个日期相差天数/*
	 */
	public int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days)) + 1;
	}

}
