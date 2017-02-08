package com.tongniu.loan.role.domain;

/**
 * 出资客户信息
 */
public class User {
	/**
	 * 唯一标识
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 身份证号码
	 */
	private String idno;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 家庭地址
	 */
	private String address;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 最近登录时间
	 */
	private String login_time;
	/**
	 * 注册时间
	 */
	private String input_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin_time() {
		return login_time!=null? login_time.substring(0,login_time.length()-2):null;
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

	public User(Integer id, String username, String password, String idno, String realname, String mobile,
			String address, String email, String login_time, String input_time) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.idno = idno;
		this.realname = realname;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.login_time = login_time;
		this.input_time = input_time;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", idno=" + idno + ", realname="
				+ realname + ", mobile=" + mobile + ", address=" + address + ", email=" + email + ", login_time="
				+ login_time + ", input_time=" + input_time + "]";
	}

}
