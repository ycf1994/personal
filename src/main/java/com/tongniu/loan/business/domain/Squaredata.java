package com.tongniu.loan.business.domain;

public class Squaredata {
	/**
	 * 唯一标识
	 * */
	private Integer id;
	/**
	 * 操作类型
	 * */
	private Integer type;
	/**
	 * 资金账户ID
	 * */
	private Integer fund_id;
	/**
	 * 交易时间
	 * */
	private Integer trade_date;
	/**
	 * 股票代码
	 * */
	private String stock_code;
	/**
	 * 股票名称
	 * */
	private String stock_name;
	/**
	 * 股票数量
	 * */
	private Integer sl;
	/**
	 * 买入价格
	 * */
	private Double now_price;
	/**
	 * 操作时间
	 * */
	private String input_time;
	/**
	 * 备注
	 * */
	private String bz;
	/**
	 * 市场ID
	 * */
	private Integer seid_id;
	/**
	 * 市场名称
	 * */
	private String seid_name;
	/**
	 * 发生资金
	 * */
	private Double occurrence_fund;
	
	public Double getOccurrence_fund() {
		return occurrence_fund;
	}
	public void setOccurrence_fund(Double occurrence_fund) {
		this.occurrence_fund = occurrence_fund;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Integer trade_date) {
		this.trade_date = trade_date;
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
	public Integer getSl() {
		return sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	public Double getNow_price() {
		return now_price;
	}
	public void setNow_price(Double now_price) {
		this.now_price = now_price;
	}
	public String getInput_time() {
		return input_time;
	}
	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
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
	public Squaredata(Integer id, Integer type, Integer fund_id, Integer trade_date, String stock_code,
			String stock_name, Integer sl, Double now_price, String input_time, String bz, Integer seid_id,
			String seid_name, Double occurrence_fund) {
		super();
		this.id = id;
		this.type = type;
		this.fund_id = fund_id;
		this.trade_date = trade_date;
		this.stock_code = stock_code;
		this.stock_name = stock_name;
		this.sl = sl;
		this.now_price = now_price;
		this.input_time = input_time;
		this.bz = bz;
		this.seid_id = seid_id;
		this.seid_name = seid_name;
		this.occurrence_fund = occurrence_fund;
	}
	public Squaredata() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Squaredata [id=" + id + ", type=" + type + ", fund_id=" + fund_id + ", trade_date=" + trade_date
				+ ", stock_code=" + stock_code + ", stock_name=" + stock_name + ", sl=" + sl + ", now_price="
				+ now_price + ", input_time=" + input_time + ", bz=" + bz + ", seid_id=" + seid_id + ", seid_name="
				+ seid_name + ", occurrence_fund=" + occurrence_fund + "]";
	}
	
	
}
