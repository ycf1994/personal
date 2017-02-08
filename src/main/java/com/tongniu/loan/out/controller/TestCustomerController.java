package com.tongniu.loan.out.controller;

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
@RequestMapping(value = "/app/vip/customer",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
@ResponseBody
public class TestCustomerController {
	@Resource
	private UserService userService;
	
	@Resource
	private AccountService accountService;
	
	@Resource
	private FlowService flowService;
	
	@Resource
	private ContractService contractService;
	
	@Resource
	private TfundacctService tfundacctService;
	
	@Resource
	private CustService custService;
	
	@Resource
	private UserCarryService userCarryService;
	
	/**
	 * 设置手势密码
	 * */
	@RequestMapping(value="/setPattern_lock")
	public String setPattern_lock(String pattern,int token){
		if(userService.setPattern_lock(pattern, token)){
			return "{\"resCode\":\"success\",\"message\":\"设置成功\"}";
		}else{
			return "{\"resCode\":\"error\",\"message\":\"设置失败\"}";
		}
	}
	/**
	 * 获取手势密码
	 * */
	@RequestMapping(value="/getPattern_lock")
	public String getPattern_lock(int token){
		try {
			String pattern=userService.getPattern_lock(token);
			if(pattern==null){
				return "{\"resCode\":\"success\",\"message\":\"获取成功\",\"pattern\":"+null+"}";
			}else{
				return "{\"resCode\":\"success\",\"message\":\"获取成功\",\"pattern\":\""+pattern+"\"}"; 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "{\"resCode\":\"error\",\"message\":\"获取失败\"}";
		}
	}
	/**
	 * 登录
	 * */
	@RequestMapping(value = "/login")
	public String login(String mobile,String password){
		User user = userService.doLogin(mobile, password);
		if (user == null) {
			return "{\"resCode\":\"error\",\"message\":\"登录失败\"}";
		} else {
			userService.updateLogin_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), user.getId());
			
			// JSON.toJSONString(object)
			return "{\"resCode\":\"success\",\"message\":\"登录成功\",\"token\":\""+user.getId()+"\"}";
		}
	}
	
	@RequestMapping(value = "/my")
	public String my(int token){
		User user = userService.getUserById(token);
		Account account = accountService.findAccountByUser_id(token);
		if(user==null||account==null)
			return "{\"resCode\":\"error\",\"message\":\"失败\"}";
		double yestodayGain = userService.getYestodayGain(Integer.valueOf(token));
		double investMoney = userService.getInvestmoney(Integer.valueOf(token));
		DecimalFormat df = new DecimalFormat("#,##0.00");
		//System.out.println(account.getSum_money());
	
		
		
		return "{\"resCode\":\"success\",\"message\":\"成功\",\"realname\":\""+user.getRealname()+"\",\"keyong\":\""+df.format(account.getSum_money() - investMoney)+"\",\"zuori\":\""+df.format(yestodayGain)+"\",\"leiji\":\""+df.format(userService.getLeiji(Integer.valueOf(token)))+"\",\"zongzichan\":\""+df.format(account.getSum_money())+"\",\"zaitou\":\""+df.format(Double.valueOf(investMoney))+"\"}";
		
	}
	
	@RequestMapping(value = "/fund")
	public String fund(int token){
		Account account = accountService.findAccountByUser_id(token);
		if(account==null)
			return "{\"resCode\":\"error\",\"message\":\"失败\"}";
		double yestodayGain = userService.getYestodayGain(Integer.valueOf(token));
		double investMoney = userService.getInvestmoney(Integer.valueOf(token));
		DecimalFormat df = new DecimalFormat("####,##0.00");
		//System.out.println(account.getSum_money());
		//BigDecimal bd = new BigDecimal(df.format((account.getSum_money() - investMoney)));
		// System.out.println(token);
		List<String> flowTypes = flowService.getFlowTypes();
		Map<Integer, String> map = new HashMap<>();
		for (String str : flowTypes) {
			String[] s = str.split("-");
			map.put(Integer.valueOf(s[0]), s[1]);
		}
		List<Flow> flowList = flowService.getFlowListByUser_id(token, 1, 99999);
		String result="[";
		for (int i = 0; i < flowList.size(); i++) {
			int flag = flowList.get(i).getFlag();
			result += " {\"money\":\"" + ((flag == 111006 || flag == 111002) ? "-" : "+")
					+df.format(flowList.get(i).getMoney()) + "\"," + "\"time\":\""
					+ flowList.get(i).getInput_time().substring(0, flowList.get(i).getInput_time().length()-2) + "\"," + "\"type\":\""
					+ map.get(flag)
					+ "\"},";
		}
		if(result.endsWith(",")) result=result.substring(0, result.length()-1);
		result+="]";
		
		
		
		return "{\"resCode\":\"success\",\"message\":\"成功\",\"zongzichan\":\""+df.format(account.getSum_money())+"\",\"keyong\":\""+df.format(account.getSum_money() - investMoney)+"\",\"zaitou\":\""+df.format(investMoney)+"\",\"flows\":"+result+"}";
	}
	
	@RequestMapping(value = "/invest")
	public String invest(int token,String type){
		DecimalFormat df = new DecimalFormat("####,##0.00");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		int contractType=-99;
		
		if("ing".equals(type)) contractType=1;
		else if("end".equals(type)) contractType=2;
		else return "{\"resCode\":\"error\",\"message\":\"失败\"}";
		List<Contract> contractList = contractService.getNeewContractListByUser_id(Integer.valueOf(token),
				contractType);
		String result="[";
		for (int i = 0; i < contractList.size(); i++) {
			try {
				result+="{\"hetonghao\":\""+contractList.get(i).getContract_no()+"\",\"kaishi\":\""+sdf2.format(sdf.parse(contractList.get(i).getStart_date()))+"\",\"jine\":\""+df.format(contractList.get(i).getContract_money())+"\",\"lilv\":\""+df.format(contractList.get(i).getInvestment_rate() * 100)+"%"+"\"},";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result.endsWith(",")) result=result.substring(0, result.length()-1);
		result+="]";
		return "{\"resCode\":\"success\",\"message\":\"成功\",\"hetongs\":"+result+"}";
	}
	
	@RequestMapping(value = "/balance")
	public String balance(int token){
		DecimalFormat df = new DecimalFormat("####,##0.00");
		Account account = accountService.findAccountByUser_id(token);
		double investMoney = userService.getInvestmoney(Integer.valueOf(token));
		if(account==null)
			return "{\"resCode\":\"error\",\"message\":\"失败\"}";
		double yestodayGain = userService.getYestodayGain(Integer.valueOf(token));
		double leijiGain=userService.getLeiji(Integer.valueOf(token));
		double keyong=account.getSum_money() - investMoney;
		List<String> lists = userService.getEveryDayGain(Integer.valueOf(token));
		String meiri="[";
		for (String list : lists) {
			// System.out.println(list);
			String[] values = list.split("--");
			meiri += "{\"shijian\":\"" + values[0] + "\",\"fene\":\"" + values[1] + "\",\"wanfen\":\"" + values[2]
					+ "\",\"shouyi\":\"" + values[3] + "\"},";
		}
		if(meiri.endsWith(",")) meiri=meiri.substring(0, meiri.length()-1);
		meiri+="]";
		
		
		List<String> lists2 = userService.getQiRiNianhua(token);
		String[] dates = new String[7];
		String[] nianhuas = new String[7];
		for (int i = 0; i < lists2.size(); i++) {
			String[] s = lists2.get(i).split("-");
			nianhuas[i] = (s[0]);
			dates[i] = s[1];
		}
		
		return "{\"resCode\":\"success\",\"message\":\"成功\",\"keyong\":\""+df.format(keyong)+"\",\"zuori\":\""+df.format(yestodayGain)+"\",\"leiji\":\""+df.format(leijiGain)+"\",\"meiri\":"+meiri+",\"dates\":[\""+dates[0]+"\",\""+dates[1]+"\",\""+dates[2]+"\",\""+dates[3]+"\",\""+dates[4]+"\",\""+dates[5]+"\",\""+dates[6]+"\"],\"nianhuas\":[\""+nianhuas[0]+"\",\""+nianhuas[1]+"\",\""+nianhuas[2]+"\",\""+nianhuas[3]+"\",\""+nianhuas[4]+"\",\""+nianhuas[5]+"\",\""+nianhuas[6]+"\"]}";
		
		
	}
	
	
	@RequestMapping(value = "/treasure")
	public String treasure(int token){
		DecimalFormat df = new DecimalFormat("####,##0.00");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		List<Contract> contractList = contractService.getNeewContractListByUser_id(Integer.valueOf(token),
				3);
		String result="[";
		for (int i = 0; i < contractList.size(); i++) {
			try {
				result+="{\"hetonghao\":\""+contractList.get(i).getContract_no()+"\",\"kaishi\":\""+sdf2.format(sdf.parse(contractList.get(i).getStart_date()))+"\",\"jine\":\""+df.format(contractList.get(i).getContract_money())+"\",\"lilv\":\""+df.format(contractList.get(i).getInvestment_rate() * 100)+"%"+"\",\"yuqi\":\""+df.format(contractList.get(i).getInvest_gain())+"\",\"qixian\":\""+(daysBetween(sdf.parse(contractList.get(i).getStart_date()),
						sdf.parse(contractList.get(i).getEnd_date()))+1)+"\"},";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result.endsWith(",")) result=result.substring(0, result.length()-1);
		result+="]";
		
		return "{\"resCode\":\"success\",\"message\":\"成功\",\"hetongs\":"+result+"}";
	}
	
	
	@RequestMapping(value = "/fanganhao")
	public String fanganhao(String hetonghao){
		DecimalFormat df = new DecimalFormat("####,##0.00");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Contract contract=contractService.getContractByContract_no(hetonghao);
		if(contract==null) return "{\"resCode\":\"error\",\"message\":\"失败\"}";
		String s=contractService.getTfundByContract_no(hetonghao);
		double sum=0;
		double fund_balance=0;
		if(s!=null){
		String[] ss = contractService.getTfundByContract_no(hetonghao).split("-");
		 fund_balance=Double.valueOf(ss[1]);
		int fund_id=Integer.valueOf(ss[0]);
		List<String> lists = tfundacctService.getStock(fund_id, hetonghao);
		 sum=0;
		for (String sss : lists) {
			String[] ssss = sss.split("-");
			sum+=Double.valueOf(ssss[2])*Double.valueOf(ssss[3]);
		}
		}
		Cust cust = custService.getCustById(contract.getCust_id());
		 try {
			return "{\"resCode\":\"success\",\"message\":\"成功\",\"hetonghao\":\""+hetonghao+"\",\"kaishi\":\""+sdf2.format(sdf.parse(contract.getStart_date()))+"\",\"jieshu\":\""+sdf2.format(sdf.parse(contract.getEnd_date()))+"\",\"lilv\":\""+df.format(contract.getInvestment_rate() * 100)+"%"+"\",\"zonge\":\""+df.format(contract.getContract_money())+"\",\"baozheng\":\""+df.format(contract.getEarnest_money())+"\",\"yuqi\":\""+df.format(contract.getInvest_gain())+"\",\"cangwei\":\""+(s==null?"0":df.format((sum/(sum+fund_balance))*100))+"%"+"\",\"state\":\""+(contract.getStates()==6?"提前终止":(contract.getStates()==3?"合同结清":"投资中"))+"\",\"xingming\":\""+cust.getRealname()+"\",\"shouji\":\""+cust.getMobile()+"\",\"shenfen\":\""+cust.getIdno()+"\"}";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	@RequestMapping(value = "/cangwei")
	public String cangwei(String hetonghao){
		DecimalFormat df = new DecimalFormat("####,##0.00");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Contract contract=contractService.getContractByContract_no(hetonghao);
		if(contract==null) return "{\"resCode\":\"error\",\"message\":\"失败\"}";
		
		String[] s = contractService.getTfundByContract_no(hetonghao).split("-");
		double fund_balance=Double.valueOf(s[1]);
		int fund_id=Integer.valueOf(s[0]);
		List<String> lists = tfundacctService.getStock(fund_id, hetonghao);
		double sum=0;
		for (String ss : lists) {
			String[] sss = ss.split("-");
			sum+=Double.valueOf(sss[2])*Double.valueOf(sss[3]);
		}
		
		String result = "[";
		for (String ss : lists) {
			String[] sss = ss.split("-");
			result += "{\"stock_code\":\"" + sss[0] + "\",\"stock_name\":\"" + sss[1] + "\",\"balance\":\"" + sss[2]
					+ "\",\"shizhi\":\"" +df.format( Double.valueOf(sss[3])*Double.valueOf(sss[2])) + "\"},";
		}
		if (result.endsWith(","))
			result = result.substring(0, result.length() - 1);
		result += "]";
		
		
		return "{\"resCode\":\"success\",\"message\":\"成功\",\"zongshizhi\":\""+df.format(sum)+"\",\"yue\":\""+df.format(fund_balance)+"\",\"zongshizhi_zhanbi\":\""+df.format((sum/(sum+fund_balance))*100)+"%"+"\",\"yue_zhanbi\":\""+df.format((fund_balance/(sum+fund_balance))*100)+"%"+"\",\"gupiaos\":"+result+"}";
	}
	@RequestMapping(value = "/money")
	public String money(int token){
		DecimalFormat df = new DecimalFormat("####,##0.00");
		String[] s = userService.getTixianBankinfo(Integer.valueOf(token)).split("-");
		Account account = accountService.findAccountByUser_id(token);
		if(account==null) return "{\"resCode\":\"error\",\"message\":\"失败\"}";
		double investMoney = userService.getInvestmoney(Integer.valueOf(token));
		System.out.println("..................");
		return "{\"resCode\":\"success\",\"message\":\"成功\",\"bank_card\":\""+(s[0]==null?"--":s[0])+"\",\"bank_name\":\""+(s[1]==null?"--":s[1])+"\",\"yue\":\""+df.format(account.getSum_money()-investMoney)+"\"}";
		
	}
	
	@RequestMapping(value = "/tixian")
	public String tixian(UserCarry userCarry, ModelMap map){
		try {
			if (userCarryService.addUserCarry(userCarry))
			
			return "{\"resCode\":\"success\",\"message\":\"成功\"}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"resCode\":\"error\",\"message\":\"失败\"}";
	}
	@RequestMapping(value = "/tixianJilu")
	public String tixianJilu(int token){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DecimalFormat df = new DecimalFormat("####,##0.00");
		User user = userService.getUserById(token);
		List<UserCarry> lists=userCarryService.findUserCarryByUser_id(Integer.valueOf(token));
		String realname=user.getRealname();
		String result="[";
		for(UserCarry us:lists){
			try {
				result+="{\"jine\":\""+df.format(us.getMoney())+"\",\"daozhang\":\""+(us.getUpdate_time()==null?"--":sdf.format(sdf.parse(us.getUpdate_time())))+"\",\"yinhang\":\""+us.getBank_card()+"\",\"zhanghu\":\""+realname+"\",\"zhuangtai\":\""+(us.getStatus()==0?"未处理":(us.getStatus()==1?"提现成功":"提现失败"))+"\"},";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result.endsWith(","))
			result = result.substring(0, result.length() - 1);
		result += "]";
		return "{\"resCode\":\"success\",\"message\":\"成功\",\"jilu\":"+result+"}";
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
	private String code() {
		return String.valueOf(((int) ((Math.random() * 9 + 1) * 100000)));
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
}
