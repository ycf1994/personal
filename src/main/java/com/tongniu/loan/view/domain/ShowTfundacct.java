package com.tongniu.loan.view.domain;

public class ShowTfundacct {
	private Integer fund_id;
	private String fund_acct;
	private String realname;
	private String idno;
	private Double fund_balance;
	public Double getFund_balance() {
		return fund_balance;
	}
	public void setFund_balance(Double fund_balance) {
		this.fund_balance = fund_balance;
	}
	public Integer getFund_id() {
		return fund_id;
	}
	public void setFund_id(Integer fund_id) {
		this.fund_id = fund_id;
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
	public String getFund_acct() {
		return fund_acct;
	}
	public void setFund_acct(String fund_acct) {
		this.fund_acct = fund_acct;
	}
	public ShowTfundacct(Integer fund_id, String fund_acct, String realname, String idno, Double fund_balance) {
		super();
		this.fund_id = fund_id;
		this.fund_acct = fund_acct;
		this.realname = realname;
		this.idno = idno;
		this.fund_balance = fund_balance;
	}
	public ShowTfundacct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
