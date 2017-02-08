package com.tongniu.loan.interest.domain;

/**
 * 投资利息
 */
public class InvestmentInterest {
	/**
	 * 唯一标识
	 */
	private Integer id;
	/**
	 * 用户编号
	 */
	private Integer user_id;
	/**
	 * 合同编号
	 */
	private String contract_no;
	/**
	 * 资金编号
	 */
	private String investment_account_no;
	/**
	 * 投资利息
	 */
	private Double investment_interest;
	/**
	 * 信息录入时间
	 */
	private String input_time;
	/**
	 * 哪天的利息
	 */
	private String interest_date;
	private Double rate;
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
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
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	
	public Double getInvestment_interest() {
		return investment_interest;
	}
	public void setInvestment_interest(Double investment_interest) {
		this.investment_interest = investment_interest;
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
	public InvestmentInterest(Integer id, Integer user_id, String contract_no, String investment_account_no,
			Double investment_interest, String input_time, String interest_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.contract_no = contract_no;
		this.investment_account_no = investment_account_no;
		this.investment_interest = investment_interest;
		this.input_time = input_time;
		this.interest_date = interest_date;
	}
	public InvestmentInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InvestmentInterest [id=" + id + ", user_id=" + user_id + ", contract_no=" + contract_no
				+ ", investment_account_no=" + investment_account_no + ", investment_interest=" + investment_interest
				+ ", input_time=" + input_time + ", interest_date=" + interest_date + "]";
	}
	
}
