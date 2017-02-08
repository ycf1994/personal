package com.tongniu.loan.account.domain;

/**
 * 客户投资资金信息
 */
public class InvestmentAccount {
	/**
	 * 唯一标识
	 */
	private Integer id;
	/**
	 * 资金编号
	 */
	private String investment_account_no;
	/**
	 * 投资客户ID
	 */
	private Integer user_id;
	/**
	 * 投入金额
	 */
	private Double money;
	/**
	 * 余额
	 */
	private Double balance;
	/**
	 * 活期利率
	 */
	private Double interest_rate;
	/**
	 * 银行卡号
	 */
	private String bank_card;
	/**
	 * 银行名称
	 */
	private String bank_name;
	/**
	 * 资金录入时间
	 */
	private String input_time;
	/**
	 * 资金计息开始时间
	 */
	private String start_date;

	/***
	 * 
	 * 资金计息结束日期 *
	 */
	private String end_date;

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = formatMoney(money);
	}

	private Double formatMoney(String money) {
		return Double.valueOf(money.replace(",", ""));
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(Double interest_rate) {
		this.interest_rate = interest_rate / 100;
	}

	public String getInput_time() {
		return input_time;
	}

	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}

	public String getBank_card() {
		return bank_card;
	}

	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getInvestment_account_no() {
		return investment_account_no;
	}

	public void setInvestment_account_no(String investment_account_no) {
		this.investment_account_no = investment_account_no;
	}

	public InvestmentAccount(Integer id, String investment_account_no, Integer user_id, Double money, Double balance,
			Double interest_rate, String bank_card, String bank_name, String input_time) {
		super();
		this.id = id;
		this.investment_account_no = investment_account_no;
		this.user_id = user_id;
		this.money = money;
		this.balance = balance;
		this.interest_rate = interest_rate;
		this.bank_card = bank_card;
		this.bank_name = bank_name;
		this.input_time = input_time;
	}

	public InvestmentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InvestmentAccount [id=" + id + ", investment_account_no=" + investment_account_no + ", user_id="
				+ user_id + ", money=" + money + ", balance=" + balance + ", interest_rate=" + interest_rate
				+ ", bank_card=" + bank_card + ", bank_name=" + bank_name + ", input_time=" + input_time + "]";
	}

}
