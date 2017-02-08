package com.tongniu.loan.view.domain;

public class ShowAccount {

	/**
	 * 用户ID
	 */
	private Integer user_id;
	/**
	 * 账户编号
	 * */
	private Integer account_id;
	/**
	 * 用户名
	 * */
	private String username;
	/**
	 * 真实姓名
	 * */
	private String realname;
	/**
	 * 入账资金
	 */
	private Double amount_money;
	/**
	 * 收益
	 */
	private Double gain;
	/**
	 * 活期利率
	 */
	private Double interest_rate;
	/**
	 * 总余额（本金+收益）
	 */
	private Double sum_money;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Double getAmount_money() {
		return amount_money;
	}
	public void setAmount_money(Double amount_money) {
		this.amount_money = amount_money;
	}
	public Double getGain() {
		return gain;
	}
	public void setGain(Double gain) {
		this.gain = gain;
	}
	public Double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(Double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public Double getSum_money() {
		return sum_money;
	}
	public void setSum_money(Double sum_money) {
		this.sum_money = sum_money;
	}
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ShowAccount(Integer user_id, Integer account_id, String username, Double amount_money, Double gain,
			Double interest_rate, Double sum_money) {
		super();
		this.user_id = user_id;
		this.account_id = account_id;
		this.username = username;
		this.amount_money = amount_money;
		this.gain = gain;
		this.interest_rate = interest_rate;
		this.sum_money = sum_money;
	}
	public ShowAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	

}
