package com.tongniu.loan.interest.domain;

/**
 * 活期利息
 * */
public class CurrentInterest {
	/**
	 * 唯一标识
	 * */
	private Integer id;
	/**
	 * 用户编号
	 * */
	private Integer user_id;
	/**
	 * 资金编号
	 * */
	private String investment_account_no;
	/**
	 * 活期利息
	 * */
	private Double current_interest;
	/**
	 * 信息录入时间
	 * */
	private String input_time;
	/**
	 * 哪天利息
	 * */
	private String interest_date;
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
	public Double getCurrent_interest() {
		return current_interest;
	}
	public void setCurrent_interest(Double current_interest) {
		this.current_interest = current_interest;
	}
	public String getInput_time() {
		return input_time;
	}
	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}
	public String getInterest_date() {
		return interest_date;
	}
	public void setInterest_date(String interest_date) {
		this.interest_date = interest_date;
	}
	public String getInvestment_account_no() {
		return investment_account_no;
	}
	public void setInvestment_account_no(String investment_account_no) {
		this.investment_account_no = investment_account_no;
	}
	public CurrentInterest(Integer id, Integer user_id, String investment_account_no, Double current_interest,
			String input_time, String interest_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.investment_account_no = investment_account_no;
		this.current_interest = current_interest;
		this.input_time = input_time;
		this.interest_date = interest_date;
	}
	public CurrentInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CurrentInterest [id=" + id + ", user_id=" + user_id + ", investment_account_no=" + investment_account_no
				+ ", current_interest=" + current_interest + ", input_time=" + input_time + ", interest_date="
				+ interest_date + "]";
	}
	
}
