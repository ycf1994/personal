package com.tongniu.loan.business.domain;

public class Parameter {
	/**
	 * 编号
	 * */
	private Integer serial_no;
	/**
	 * 参数id
	 * */
	private Integer type_id;
	/**
	 * 参数类型
	 * */
	private String type_name;
	/**
	 * 参数值
	 * */
	private String type_value;
	/**
	 * 参数内容
	 * */
	private String type_content;
	public Integer getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(Integer serial_no) {
		this.serial_no = serial_no;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getType_value() {
		return type_value;
	}
	public void setType_value(String type_value) {
		this.type_value = type_value;
	}
	public String getType_content() {
		return type_content;
	}
	public void setType_content(String type_content) {
		this.type_content = type_content;
	}
	public Parameter(Integer serial_no, Integer type_id, String type_name, String type_value, String type_content) {
		super();
		this.serial_no = serial_no;
		this.type_id = type_id;
		this.type_name = type_name;
		this.type_value = type_value;
		this.type_content = type_content;
	}
	public Parameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
