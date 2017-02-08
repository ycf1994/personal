package com.tongniu.loan.business.domain;

public class Tstockinfo {
	/**
	 * 唯一标识
	 */
	private Integer stock_id;
	/**
	 * 股票代码
	 */
	private String stock_code;
	/**
	 * 股票名称
	 */
	private String stock_name;
	/**
	 * 股票类型
	 */
	private String stock_type;
	/**
	 * 股票类型名称
	 */
	private String stock_type_name;
	/**
	 * 市场ID
	 */
	private String seid_id;
	/**
	 * 市场名称
	 */
	private String seid_name;

	public Integer getStock_id() {
		return stock_id;
	}

	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
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

	public String getStock_type() {
		return stock_type;
	}

	public void setStock_type(String stock_type) {
		this.stock_type = stock_type;
	}

	public String getStock_type_name() {
		return stock_type_name;
	}

	public void setStock_type_name(String stock_type_name) {
		this.stock_type_name = stock_type_name;
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

	public Tstockinfo(Integer stock_id, String stock_code, String stock_name, String stock_type, String stock_type_name,
			String seid_id, String seid_name) {
		super();
		this.stock_id = stock_id;
		this.stock_code = stock_code;
		this.stock_name = stock_name;
		this.stock_type = stock_type;
		this.stock_type_name = stock_type_name;
		this.seid_id = seid_id;
		this.seid_name = seid_name;
	}

	public Tstockinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tstockinfo [stock_id=" + stock_id + ", stock_code=" + stock_code + ", stock_name=" + stock_name
				+ ", stock_type=" + stock_type + ", stock_type_name=" + stock_type_name + ", seid_id=" + seid_id
				+ ", seid_name=" + seid_name + "]";
	}
}
