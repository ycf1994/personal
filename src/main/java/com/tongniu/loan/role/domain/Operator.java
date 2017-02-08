package com.tongniu.loan.role.domain;

/**
 * 操作员
 */
public class Operator {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 工号
	 */
	private String opcode;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 最近登录时间
	 */
	private String login_time;
	/**
	 * 录入时间
	 */
	private String input_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpcode() {
		return opcode;
	}

	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getLogin_time() {
		return login_time==null?"--":login_time.substring(0, login_time.length()-2);
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public String getInput_time() {
		return input_time;
	}

	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}

	public Operator(Integer id, String opcode, String username, String password, String realname, String login_time,
			String input_time) {
		super();
		this.id = id;
		this.opcode = opcode;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.login_time = login_time;
		this.input_time = input_time;
	}

	public Operator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", opcode=" + opcode + ", username=" + username + ", password=" + password
				+ ", realname=" + realname + ", login_time=" + login_time + ", input_time=" + input_time + "]";
	}

}
