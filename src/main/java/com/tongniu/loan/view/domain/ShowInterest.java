package com.tongniu.loan.view.domain;

public class ShowInterest {
	private Integer user_id;
	private String realname;
	private String username;
	private Double sum_current_interest;
	private Double sum_investment_interest;
	private String interest_date;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getSum_current_interest() {
		return sum_current_interest;
	}
	public void setSum_current_interest(Double sum_current_interest) {
		this.sum_current_interest = sum_current_interest;
	}
	public Double getSum_investment_interest() {
		return sum_investment_interest;
	}
	public void setSum_investment_interest(Double sum_investment_interest) {
		this.sum_investment_interest = sum_investment_interest;
	}
	public String getInterest_date() {
		return interest_date;
	}
	public void setInterest_date(String interest_date) {
		this.interest_date = interest_date;
	}
	public ShowInterest(Integer user_id, String realname, String username, Double sum_current_interest,
			Double sum_investment_interest, String interest_date) {
		super();
		this.user_id = user_id;
		this.realname = realname;
		this.username = username;
		this.sum_current_interest = sum_current_interest;
		this.sum_investment_interest = sum_investment_interest;
		this.interest_date = interest_date;
	}
	public ShowInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ShowInterest [user_id=" + user_id + ", realname=" + realname + ", username=" + username
				+ ", sum_current_interest=" + sum_current_interest + ", sum_investment_interest="
				+ sum_investment_interest + ", interest_date=" + interest_date + "]";
	}
}
