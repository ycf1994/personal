package com.tongniu.loan.view.domain;

public class ShowInvestment_account {
	private String investment_account_no;
	private String username;
	private String realname;
	private String idno;
	private Double money;
	private Double balance;
	private Double  interest_rate;
	private String input_time;
	private Double ytx;
	private Double dsh;
	private String start_date;
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

	public Double getYtx() {
		return ytx;
	}

	public void setYtx(Double ytx) {
		this.ytx = ytx;
	}

	public Double getDsh() {
		return dsh;
	}

	public void setDsh(Double dsh) {
		this.dsh = dsh;
	}

	public String getInvestment_account_no() {
		return investment_account_no;
	}

	public void setInvestment_account_no(String investment_account_no) {
		this.investment_account_no = investment_account_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
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
		this.interest_rate = interest_rate;
	}

	public String getInput_time() {
		return input_time;
	}

	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}

	public ShowInvestment_account(String investment_account_no, String username, String realname, String idno,
			Double money, Double balance, Double interest_rate, String input_time, Double ytx, Double dsh) {
		super();
		this.investment_account_no = investment_account_no;
		this.username = username;
		this.realname = realname;
		this.idno = idno;
		this.money = money;
		this.balance = balance;
		this.interest_rate = interest_rate;
		this.input_time = input_time;
		this.ytx = ytx;
		this.dsh = dsh;
	}

	public ShowInvestment_account() {
		super();
		// TODO Auto-generated constructor stub
	}
}
