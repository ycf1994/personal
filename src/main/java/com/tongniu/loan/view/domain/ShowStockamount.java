package com.tongniu.loan.view.domain;

public class ShowStockamount {
	private String cust_name;
	private String fund_acct;
	private String stock_code;
	private String stock_name;
	private String seid_id;
	private String seid_name;
	private Integer balance;
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getFund_acct() {
		return fund_acct;
	}
	public void setFund_acct(String fund_acct) {
		this.fund_acct = fund_acct;
	}
	public String getStock_code() {
		return stock_code;
	}
	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public String getSeid_id() {
		return seid_id;
	}
	public void setSeid_id(String seid_id) {
		this.seid_id = seid_id;
	}
	public String getSeid_name() {
		return seid_name;
	}
	public void setSeid_name(String seid_name) {
		this.seid_name = seid_name;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public ShowStockamount(String cust_name, String fund_acct, String stock_code, String stock_name, String seid_id,
			String seid_name, Integer balance) {
		super();
		this.cust_name = cust_name;
		this.fund_acct = fund_acct;
		this.stock_code = stock_code;
		this.stock_name = stock_name;
		this.seid_id = seid_id;
		this.seid_name = seid_name;
		this.balance = balance;
	}
	public ShowStockamount() {
		super();
		// TODO Auto-generated constructor stub
	}
}
