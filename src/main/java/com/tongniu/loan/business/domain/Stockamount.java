package com.tongniu.loan.business.domain;

/**
 * 股票汇总（持有总数）
 * */
public class Stockamount {
	/**
	 * 唯一标识
	 * */
	private Integer id;
	
	/**
	 * 借款客户ID
	 * */
	private Integer cust_id;
	/**
	 * 股票代码
	 * */
	private String stock_code;
	/**
	 * 股票名称
	 * */
	private String stock_name;
	/**
	 * 合同ID
	 * */
	private String contract_no;
	/**
	 * 持有总数
	 * */
	private Integer balance;
	/**
	 * 市场编号
	 * */
	private Integer seid_id;
	/**
	 * 市场名称
	 * */
	private String seid_name;
	/**
	 * 资金账户编号
	 * */
	private Integer fund_id;
	/**
	 * 资金账户名称
	 * */
	private String fund_acct;
	public Integer getSeid_id() {
		return seid_id;
	}
	public void setSeid_id(Integer seid_id) {
		this.seid_id = seid_id;
	}
	public String getSeid_name() {
		return seid_name;
	}
	public void setSeid_name(String seid_name) {
		this.seid_name = seid_name;
	}
	public Integer getFund_id() {
		return fund_id;
	}
	public void setFund_id(Integer fund_id) {
		this.fund_id = fund_id;
	}
	public String getFund_acct() {
		return fund_acct;
	}
	public void setFund_acct(String fund_acct) {
		this.fund_acct = fund_acct;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
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
	
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public Stockamount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stockamount(Integer id, Integer cust_id, String stock_code, String stock_name, String contract_no,
			Integer balance, Integer seid_id, String seid_name, Integer fund_id, String fund_acct) {
		super();
		this.id = id;
		this.cust_id = cust_id;
		this.stock_code = stock_code;
		this.stock_name = stock_name;
		this.contract_no = contract_no;
		this.balance = balance;
		this.seid_id = seid_id;
		this.seid_name = seid_name;
		this.fund_id = fund_id;
		this.fund_acct = fund_acct;
	}
	@Override
	public String toString() {
		return "Stockamount [id=" + id + ", cust_id=" + cust_id + ", stock_code=" + stock_code + ", stock_name="
				+ stock_name + ", contract_no=" + contract_no + ", balance=" + balance + ", seid_id=" + seid_id
				+ ", seid_name=" + seid_name + ", fund_id=" + fund_id + ", fund_acct=" + fund_acct + "]";
	}
	
	
}
