package com.tongniu.loan.account.domain;

/**
 * 借款用户资金账户
 */
public class Tfundacct {
	/**
	 * 账户ID
	 */
	private Integer fund_id;
	/**
	 * 证券账户
	 */
	private String fund_acct;
	/**
	 * 借款客户ID
	 */
	private Integer cust_id;
	/**
	 * 借款客户姓名
	 */
	private String cust_name;
	/**
	 * 投资合同编号
	 */
	private String contract_no;
	/**
	 * 股票账户余额
	 */
	private Double fund_balance;
	/**
	 * 投资借款金额
	 */
	private Double contract_money;

	public Integer getFund_id() {
		return fund_id;
	}

	public void setFund_id(Integer fund_id) {
		this.fund_id = fund_id;
	}

	public String getFund_acct() {
		return fund_acct;
	}

	public void setFund_acc(String fund_acct) {
		this.fund_acct = fund_acct;
	}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getContract_no() {
		return contract_no;
	}

	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	public Double getFund_balance() {
		return fund_balance;
	}

	public void setFund_balance(Double fund_balance) {
		this.fund_balance = fund_balance;
	}

	public Double getContract_money() {
		return contract_money;
	}

	public void setContract_money(Double contract_money) {
		this.contract_money = contract_money;
	}

	public Tfundacct(Integer fund_id, String fund_acct, Integer cust_id, String cust_name, String contract_no,
			Double fund_balance, Double contract_money) {
		super();
		this.fund_id = fund_id;
		this.fund_acct = fund_acct;
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.contract_no = contract_no;
		this.fund_balance = fund_balance;
		this.contract_money = contract_money;
	}

	public Tfundacct() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tfundacct [fund_id=" + fund_id + ", fund_acct=" + fund_acct + ", cust_id=" + cust_id + ", cust_name="
				+ cust_name + ", contract_no=" + contract_no + ", fund_balance=" + fund_balance + ", contract_money="
				+ contract_money + "]";
	}
}
