package com.tongniu.loan.out.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.account.domain.Account;
import com.tongniu.loan.account.service.AccountService;
import com.tongniu.loan.account.service.TfundacctService;
import com.tongniu.loan.business.domain.Contract;
import com.tongniu.loan.business.domain.Flow;
import com.tongniu.loan.business.domain.UserCarry;
import com.tongniu.loan.business.service.ContractService;
import com.tongniu.loan.business.service.FlowService;
import com.tongniu.loan.business.service.UserCarryService;
import com.tongniu.loan.role.domain.Cust;
import com.tongniu.loan.role.domain.User;
import com.tongniu.loan.role.service.CustService;
import com.tongniu.loan.role.service.UserService;
import com.tongniu.loan.sendmessage.util.SMSSent;

@Controller
@RequestMapping(value = "/vip/customer")
public class CustomerController {

	@Resource
	private UserService userService;
	@Resource
	private AccountService accountService;

	@Resource
	private ContractService contractService;

	@Resource
	private CustService custService;

	@Resource
	private FlowService flowService;

	@Resource
	private TfundacctService tfundacctService;

	@Resource
	private UserCarryService userCarryService;

	/**
	 * 登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String login(String userName, String password) {
		User user = userService.doLogin(userName, password);
		if (user == null) {
			return "{\"resCode\":\"error\",\"message\":\"登录失败\"}";
		} else {
			userService.updateLogin_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), user.getId());
			Account account = accountService.findAccountByUser_id(user.getId());
			// JSON.toJSONString(object)
			return "{\"resCode\":\"success\"," + "\"message\":\"登录成功\"," + "\"subscriber\":{" + "\"subsName\":" + "\""
					+ user.getRealname() + "\"," + "\"mobile\":\"" + user.getMobile() + "\",\"money\":\""
					+ account.getSum_money() + "\"," + "\"lockedMoney\":\"" + 0 + "\",\"token\":\"" + user.getId()
					+ "\"}}";
		}
	}

	/**
	 * 退出
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/logout", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String logout(String token) {
		token = null;
		if (token == null) {
			return "{resCode:'success',message:'退出成功'}";
		} else {
			return "{resCode:'error', message:'退出失败原因'}";
		}
	}

	private String getPlainString(double money) {
		return new BigDecimal(money).toPlainString();
	}

	/**
	 * 获取账户信息
	 */
	@RequestMapping(value = "/account", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String account(String token) {
		User user = userService.getUserById(Integer.valueOf(token));
		Account account = accountService.findAccountByUser_id(Integer.valueOf(token));
		double yestodayGain = userService.getYestodayGain(Integer.valueOf(token));
		double investMoney = userService.getInvestmoney(Integer.valueOf(token));
		DecimalFormat df = new DecimalFormat("######0.00");
		//System.out.println(account.getSum_money());
		BigDecimal bd = new BigDecimal(df.format((account.getSum_money() - investMoney)));
		// System.out.println(account.getSum_money());
		if (user != null && account != null) {
			String res = "{\"resCode\":\"success\"," + "\"message\":\"获取用户账户信息成功\"," + "\"subscriber\":{"
					+ "\"subsName\":\"" + user.getRealname() + "\"," + "\"mobile\":\"" + user.getMobile() + "\","
					+ "\"money\":\"" + (bd.toPlainString()) + "\"," + "\"lockedMoney\":\"" + 0 + "\","
					+ "\"yestodayGain\":\"" + yestodayGain + "\"," + "\"totalGain\":\""
					+ userService.getLeiji(Integer.valueOf(token)) + "\"," + "\"investMoney\":\""
					+ getPlainString(investMoney) + "\"}}";
			// System.out.println(res);
			return res;
		} else {
			return "{resCode:'error',message:'获取用户账户信息失败'}";
		}
	}
	// Interceptor

	/**
	 * 获取需要的方案记录
	 */
	@RequestMapping(value = "/contract/list", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String contract_list(String token, Integer contractType) {
		// System.out.println("contractType--" + contractType);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		List<Contract> contractList = contractService.getNeewContractListByUser_id(Integer.valueOf(token),
				contractType);
		if (contractList != null && contractList.size() > 0) {
			String result = "[";
			for (int i = 0; i < contractList.size(); i++) {
				try {
					result += "{\"contractState\":\"" + contractList.get(i).getStates() + "\"," + "\"contractId\":\""
							+ contractList.get(i).getId() + "\"," + "\"contractName\":\""
							+ contractList.get(i).getContract_no() + "\"," + "\"startDate\":\""
							+ sdf2.format(sdf.parse(contractList.get(i).getStart_date())) + "\","
							+ "\"contractTerm\":\""
							+ daysBetween(sdf.parse(contractList.get(i).getStart_date()),
									sdf.parse(contractList.get(i).getEnd_date()))
							+ "天\"," + "\"investMoney\":\""
							+ new BigDecimal(contractList.get(i).getContract_money()).toPlainString() + "\","
							+ "\"investGain\":\"" + contractList.get(i).getInvest_gain() + "\",\"rate\":\""
							+ contractList.get(i).getInvestment_rate() * 100 + "\"},";
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (result.endsWith(",")) {
				result = result.substring(0, result.length() - 1);
			}
			result += "]";
			String res = "{\"resCode\":\"success\",\"message\":\"获取投资方案记录成功\",\"result\":" + result + "}";

			return res;
		} else {
			return "{ \"resCode\":\"error\", \"message\":\"获取投资方案记录失败\"}";
		}
	}

	/**
	 * 获取投资方案详情
	 */
	@RequestMapping(value = "/contract/detail", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String contract_detail(String token, Integer contractId) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			Contract contract = contractService.getContractByContractId(contractId);
			if (contract == null) {
				return "{resCode:'error',message:'获取投资方案记录失败'}";
			} else {
				Cust cust = custService.getCustById(contract.getCust_id());
				return "{\"contractState\":\"" + contract.getStates() + "\",\"resCode\":\"success\","
						+ "\"message\":\"获取投资方案记录成功\"," + "\"contractName\":\"" + contract.getContract_no() + "\","
						+ "\"startDate\":\"" + sdf2.format(sdf.parse(contract.getStart_date())) + "\","
						+ "\"endDate\":\"" + sdf2.format(sdf.parse(contract.getEnd_date())) + "\","
						+ "\"annualYield\":\"" + contract.getInvestment_rate() * 100 + "\"," + "\"investMoney\" :\""
						+ contract.getContract_money() + "\"," + "\"investGain\":\"" + contract.getInvest_gain() + "\","
						+ "\"borrowerName\":\"" + cust.getRealname() + "\"," + "\"borrowerMobile\":\""
						+ cust.getMobile() + "\"," + "\"borrowerCardNo\":\"" + cust.getIdno() + "\","
						+ "\"contractMoney\":\"" + contract.getContract_money() + "\",\"earnest_money\":\""
						+ contract.getEarnest_money() + "\"}";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取资金流水
	 */
	@RequestMapping(value = "/money/list", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String money_list(String token, Integer page,Integer type) {
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		// System.out.println(token);
		List<String> flowTypes = flowService.getFlowTypes();
		Map<Integer, String> map = new HashMap<>();
		for (String str : flowTypes) {
			String[] s = str.split("-");
			map.put(Integer.valueOf(s[0]), s[1]);
		}
		List<Flow> flowList = flowService.getFlowListByUser_id(Integer.valueOf(token), page, 99999);
		// System.out.println(flowList.size());
		if (flowList != null && flowList.size() > 0) {
			
			int count = flowService.getFlowListByUser_idCount((Integer.valueOf(token)));
			String result = "[";
			for (int i = 0; i < flowList.size(); i++) {
				int flag = flowList.get(i).getFlag();
				if(type==null){
				result += " {\"money\":\"" + ((flag == 111006 || flag == 111002) ? "-" : "+")
						+ new BigDecimal(flowList.get(i).getMoney()).toPlainString() + "\"," + "\"time\":\""
						+ flowList.get(i).getInput_time() + "\"," + "\"type\":\""
						+ (flag == 111001 ? "<span style='margin-right:1.7rem;'  >" + map.get(flag) + "</span>"
								: (flag == 111006 ? "<span style='margin-right:4.7rem;'  >" + map.get(flag) + "</span>"
										: (flag == 111004
												? "<span style='margin-right:1.7rem;' >" + map.get(flag) + "</span>"
												: (flag == 111005
														? "<span style='margin-right:1.7rem;' >" + map.get(flag)
																+ "</span>"
														: (flag == 111002
																? "<span style='margin-right:4.7rem;' >" + map.get(flag)
																		+ "</span>"
																: "<span style='margin-right:4.7rem;' >" + map.get(flag)
																		+ "</span>")))))
						+ "\"},";
				}else{
					
					result += " {\"money\":\"" + ((flag == 111006 || flag == 111002) ? "-" : "+")
							+df.format(flowList.get(i).getMoney()) + "\"," + "\"time\":\""
							+ flowList.get(i).getInput_time().substring(0, flowList.get(i).getInput_time().length()-2) + "\"," + "\"type\":\""
							+ map.get(flag)
							+ "\"},";
				}
			}
			if (result.endsWith(",")) {
				result = result.substring(0, result.length() - 1) + "]";
			}
			// System.out.println(result);
			return "{ \"resCode\":\"success\"," + "\"message\":\"获取资金流水记录成功\"," + "\"count\":\"" + count + "\","
					+ "\"pageNum\":\"" + page + "\"," + "\"pageSize\":\"" + 10 + "\"," + "\"nexePage\":\"" + (page + 1)
					+ "\"," + "\"pages\":\"" + (count % page == 0 ? count / page : count / page + 1) + "\","
					+ "\"result\":" + result + "}";
		} else {
			return "{\"resCode\":\"error\",\"message\":\"获取资金流水记录失败原因\"}";
		}

	}

	/**
	 * 获取每日收益
	 */
	@RequestMapping(value = "/gain/list", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getEveryDayGain(String token) {
		String res;
		try {
			List<String> lists = userService.getEveryDayGain(Integer.valueOf(token));

			double yestodayYueGain = userService.getYestodayYueGain(Integer.valueOf(token));
			double yueLeiji = userService.getYueLeiji(Integer.valueOf(token));

			String result = "[";
			for (String list : lists) {
				// System.out.println(list);
				String[] values = list.split("--");
				result += "{\"shijian\":\"" + values[0] + "\",\"fene\":\"" + values[1] + "\",\"wanfen\":\"" + values[2]
						+ "\",\"shouyi\":\"" + values[3] + "\"},";
			}
			if (result.endsWith(","))
				result = result.substring(0, result.length() - 1);
			result += "]";
			res = "{\"resCode\":\"success\",\"message\":\"获取每日收益成功\"," + "\"yestodayYueGain\":\"" + yestodayYueGain
					+ "\",\"yueLeiji\":\"" + yueLeiji + "\",\"result\":" + result + "}";
			return res;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"resCode\":\"error\",\"message\":\"获取每日收益失败\"}";

	}

	/**
	 * 获取仓位情况
	 */
	@RequestMapping(value = "/contract/cangwei", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getCangwei(Integer contractId) {

		try {
			String s = contractService.getTfund(contractId);
			// System.out.println(s);
			String[] ss = s.split("-");
			return "{\"resCode\":\"success\",\"message\":\"获取仓位信息成功\",\"fund_id\":\"" + ss[0] + "\",\"fund_balance\":\""
					+ ss[1] + "\",\"contract_money\":\"" + ss[2] + "\"}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"resCode\":\"error\",\"message\":\"获取仓位信息失败\"}";
	}

	/**
	 * 获取仓位股票
	 */
	@RequestMapping(value = "/contract/getStock", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getStock(Integer fund_id, String contract_no) {
		try {
			List<String> lists = tfundacctService.getStock(fund_id, contract_no);

			String result = "[";
			for (String s : lists) {
				String[] ss = s.split("-");
				result += "{\"stock_code\":\"" + ss[0] + "\",\"stock_name\":\"" + ss[1] + "\",\"balance\":\"" + ss[2]
						+ "\",\"now_price\":\"" + ss[3] + "\"},";
			}
			if (result.endsWith(","))
				result = result.substring(0, result.length() - 1);
			result += "]";

			return "{\"resCode\":\"success\",\"message\":\"获取仓位股票信息成功\",\"result\":" + result + "}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"resCode\":\"error\",\"message\":\"获取仓位股票信息失败\"}";
	}

	/**
	 * 获取提现卡号和银行名称
	 */
	@RequestMapping(value = "/money/tixian", method = RequestMethod.GET,produces = "application/json; charset=utf-8" )
	@ResponseBody
	public String getTixianBankinfo(String token, ModelMap map) {
		String s = userService.getTixianBankinfo(Integer.valueOf(token));

		if (s != null) {
			String[] ss = s.split("-");

			map.put("resCode", "success");
			map.put("message", "获取提现信息成功");
			map.put("bank_card", ss[0]);
			map.put("bank_name", ss[1]);
			return JSON.toJSONString(map);
		} else {
			return "{\"resCode\":\"error\",\"message\":\"获取提现信息失败\"}";
		}
	}
	

	/**
	 * 提现
	 */
	@RequestMapping(value = "/withdraw/apply", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String apply(UserCarry userCarry, ModelMap map) {
		try {
			if (userCarryService.addUserCarry(userCarry))
				map.put("resCode", "success");
			map.put("message", "提现申请成功");
			return "{\"resCode\":\"success\",\"message\":\"提现申请成功\"}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"resCode\":\"error\",\"message\":\"提现申请失败\"}";
	}

	/**
	 * 提现记录
	 */
	@RequestMapping(value = "/withdraw/list", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String list(String token, ModelMap map) {
		try {
			map.put("resCode", "success");
			map.put("message", "获取提现记录成功");
			map.put("list", userCarryService.findUserCarryByUser_id(Integer.valueOf(token)));
			return JSON.toJSONString(map);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"resCode\":\"error\",\"message\":\"获取提现记录失败\"}";
	}

	/**
	 * 重置密码
	 */
	@RequestMapping(value="/setPwd",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String setPwd(String newPwd, String phone, ModelMap map) {

		boolean flag = userService.setPwd(newPwd, phone);
		if (flag) {
			map.put("resCode", "success");
			map.put("message", "重置密码成功");
			map.put("msg", true);
			return JSON.toJSONString(map);
		}

		return "{\"resCode\":\"error\",\"message\":\"重置密码失败\"}";
	}

	/**
	 * 发送验证码
	 */
	@RequestMapping(value = "/sendCode",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String sendCode(String phone, ModelMap map) {
		String code = code();
		boolean flag = SMSSent.sendCode(phone, code);
		if (flag) {
			map.put("resCode", "success");
			map.put("message", "发送验证码成功");
			map.put("code", code);
			map.put("phone", phone);
		} else {
			map.put("resCode", "error");
			map.put("message", "发送验证码失败");
		}
		return JSON.toJSONString(map);
		
	}

	/**
	 * 获取用户资金七日年化
	 */
	@RequestMapping(value = "/qiriNianhua",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String qiriNianhua(Integer token, ModelMap map) {
		try {
			List<String> lists = userService.getQiRiNianhua(token);
			String[] dates = new String[7];
			String[] nianhuas = new String[7];
			for (int i = 0; i < lists.size(); i++) {
				String[] s = lists.get(i).split("-");
				nianhuas[i] = (s[0]);
				dates[i] = s[1];
			}
			map.put("resCode", "success");
			map.put("message", "获取七日年化成功");
			map.put("dates", dates);
			map.put("nianhuas", nianhuas);
			return JSON.toJSONString(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"resCode\":\"error\",\"message\":\"获取七日年化失败\"}";
	}

	/**
	 * 两个日期相差天数/*
	 */
	public int daysBetween(Date smdate, Date bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	private String code() {
		return String.valueOf(((int) ((Math.random() * 9 + 1) * 100000)));
	}

	public static void main(String[] args) {
		System.out.println(new CustomerController().code());
	}

}
