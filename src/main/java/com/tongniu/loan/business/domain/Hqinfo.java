package com.tongniu.loan.business.domain;

public class Hqinfo {
	private int serial_no;
	private int stock_id;
	private String stock_code;
	private String stock_name;
	private double last_price;
	private double now_price;
	private int hq_date;
	private int hq_end_date;
	private String input_time;
	public int getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
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
	public double getLast_price() {
		return last_price;
	}
	public void setLast_price(double last_price) {
		this.last_price = last_price;
	}
	public double getNow_price() {
		return now_price;
	}
	public void setNow_price(double now_price) {
		this.now_price = now_price;
	}
	public int getHq_date() {
		return hq_date;
	}
	public void setHq_date(int hq_date) {
		this.hq_date = hq_date;
	}
	public int getHq_end_date() {
		return hq_end_date;
	}
	public void setHq_end_date(int hq_end_date) {
		this.hq_end_date = hq_end_date;
	}
	public String getInput_time() {
		return input_time;
	}
	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}
	public Hqinfo(int serial_no, int stock_id, String stock_code, String stock_name, double last_price,
			double now_price, int hq_date, int hq_end_date, String input_time) {
		super();
		this.serial_no = serial_no;
		this.stock_id = stock_id;
		this.stock_code = stock_code;
		this.stock_name = stock_name;
		this.last_price = last_price;
		this.now_price = now_price;
		this.hq_date = hq_date;
		this.hq_end_date = hq_end_date;
		this.input_time = input_time;
	}
	public Hqinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
