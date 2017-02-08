package com.tongniu.loan.view.domain;

/**
 * 显示流水
 */
public class ShowFlow {
	private Integer id;
	private String deal_no;
	private Integer user_id;
	private String bank_card;
	private String bank_name;
	private Double money;
	private String input_time;
	private String transferred_time;
	private Integer flag;
	private String username;
	private String realname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeal_no() {
		return deal_no;
	}

	public void setDeal_no(String deal_no) {
		this.deal_no = deal_no;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getBank_card() {
		return bank_card;
	}

	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getInput_time() {
		return input_time;
	}

	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}

	public String getTransferred_time() {
		return transferred_time;
	}

	public void setTransferred_time(String transferred_time) {
		this.transferred_time = transferred_time;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
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

	public ShowFlow(Integer id, String deal_no, Integer user_id, String bank_card, String bank_name, Double money,
			String input_time, String transferred_time, Integer flag, String username, String realname) {
		super();
		this.id = id;
		this.deal_no = deal_no;
		this.user_id = user_id;
		this.bank_card = bank_card;
		this.bank_name = bank_name;
		this.money = money;
		this.input_time = input_time;
		this.transferred_time = transferred_time;
		this.flag = flag;
		this.username = username;
		this.realname = realname;
	}

	public ShowFlow() {
		super();
		// TODO Auto-generated constructor stub
	}
}
