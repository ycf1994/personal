package com.tongniu.loan.account.domain;

/**
 * 出资用户资金账户
 */
public class Account {
	/**
	 * 唯一标识
	 */
	private Integer id;
	/**
	 * 用户ID
	 */
	private Integer user_id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Account(Integer id, Integer user_id, Double amount_money, Double gain, Double interest_rate,
			Double sum_money) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.amount_money = amount_money;
		this.gain = gain;
		this.interest_rate = interest_rate;
		this.sum_money = sum_money;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
