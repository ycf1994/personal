package com.tongniu.loan.business.domain;

/**
 * 用户提现记录
 */
public class UserCarry {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 用户编号
	 */
	private Integer user_id;
	/**
	 * 提现金额
	 */
	private Double money;
	/**
	 * 银行id
	 */
	private Integer bank_id;
	/**
	 * 银行卡号
	 */
	private String bank_card;
	/**
	 * 提现状态 0 未处理 1 处理 3 关闭
	 */
	private byte status;
	/**
	 * 创建时间
	 */
	private String create_time;
	/**
	 * 处理时间
	 */
	private String update_time;

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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getBank_id() {
		return bank_id;
	}

	public void setBank_id(Integer bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_card() {
		return bank_card;
	}

	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public UserCarry(Integer id, Integer user_id, Double money, Integer bank_id, String bank_card, byte status,
			String create_time, String update_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.money = money;
		this.bank_id = bank_id;
		this.bank_card = bank_card;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public UserCarry() {
		super();
		// TODO Auto-generated constructor stub
	}

}
