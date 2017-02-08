package com.tongniu.loan.view.domain;

public class ShowContract {
	private String contract_no;
	private String user;
	private String cust;
	private Double contract_money;
	private String sign_date;
	private String start_date;
	private String end_date;
	private Double investment_rate;
	private Integer states;
	private Double invest_gain;
	private Double sum_gain;
	private String check_name;
	private String check_time;
	private Integer fund_id;
	private String fund_acc;
	private String investment_account_no;
	/**
	 * 保证金
	 * */
	private Double earnest_money;
	/**
	 * 总金额
	 * */
	private Double sum_money;
	
	public Double getEarnest_money() {
		return earnest_money;
	}
	public void setEarnest_money(Double earnest_money) {
		this.earnest_money = earnest_money;
	}
	public Double getSum_money() {
		return sum_money;
	}
	public void setSum_money(Double sum_money) {
		this.sum_money = sum_money;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCust() {
		return cust;
	}
	public void setCust(String cust) {
		this.cust = cust;
	}
	public Double getContract_money() {
		return contract_money;
	}
	public void setContract_money(Double contract_money) {
		this.contract_money = contract_money;
	}
	public String getSign_date() {
		return sign_date==null?null:sign_date.substring(0, 10);
	}
	public void setSign_date(String sign_date) {
		this.sign_date = sign_date;
	}
	public String getStart_date() {
		return start_date==null?null:start_date.substring(0, 10);
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date==null?null:end_date.substring(0, 10);
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public Double getInvestment_rate() {
		return investment_rate;
	}
	public void setInvestment_rate(Double investment_rate) {
		this.investment_rate = investment_rate;
	}
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
	public Double getInvest_gain() {
		return invest_gain;
	}
	public void setInvest_gain(Double invest_gain) {
		this.invest_gain = invest_gain;
	}
	public Double getSum_gain() {
		return sum_gain;
	}
	public void setSum_gain(Double sum_gain) {
		this.sum_gain = sum_gain;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public String getCheck_time() {
		return check_time==null?"":check_time.substring(0, check_time.length()-2);
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public Integer getFund_id() {
		return fund_id;
	}
	public void setFund_id(Integer fund_id) {
		this.fund_id = fund_id;
	}
	public String getFund_acc() {
		return fund_acc;
	}
	public void setFund_acc(String fund_acc) {
		this.fund_acc = fund_acc;
	}
	public String getInvestment_account_no() {
		return investment_account_no;
	}
	public void setInvestment_account_no(String investment_account_no) {
		this.investment_account_no = investment_account_no;
	}
	public ShowContract(String contract_no, String user, String cust, Double contract_money, String sign_date,
			String start_date, String end_date, Double investment_rate, Integer states, Double invest_gain,
			Double sum_gain, String check_name, String check_time, Integer fund_id, String fund_acc,
			String investment_account_no) {
		super();
		this.contract_no = contract_no;
		this.user = user;
		this.cust = cust;
		this.contract_money = contract_money;
		this.sign_date = sign_date;
		this.start_date = start_date;
		this.end_date = end_date;
		this.investment_rate = investment_rate;
		this.states = states;
		this.invest_gain = invest_gain;
		this.sum_gain = sum_gain;
		this.check_name = check_name;
		this.check_time = check_time;
		this.fund_id = fund_id;
		this.fund_acc = fund_acc;
		this.investment_account_no = investment_account_no;
	}
	public ShowContract() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ShowContract [contract_no=" + contract_no + ", user=" + user + ", cust=" + cust + ", contract_money="
				+ contract_money + ", sign_date=" + sign_date + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", investment_rate=" + investment_rate + ", states=" + states + ", invest_gain=" + invest_gain
				+ ", sum_gain=" + sum_gain + ", check_name=" + check_name + ", check_time=" + check_time + ", fund_id="
				+ fund_id + ", fund_acc=" + fund_acc + ", investment_account_no=" + investment_account_no + "]";
	}
	
}
