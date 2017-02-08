package com.tongniu.loan.role.domain;

/**
 * 借款客户信息
 */
public class Cust {
	/**
	 * 唯一标识
	 */
	private Integer id;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 身份证号码
	 */
	private String idno;
	/**
	 * 手机号码
	 */
	private String mobile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Cust(Integer id, String realname, String idno, String mobile) {
		super();
		this.id = id;
		this.realname = realname;
		this.idno = idno;
		this.mobile = mobile;
	}

	public Cust() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cust [id=" + id + ", realname=" + realname + ", idno=" + idno + ", mobile=" + mobile + "]";
	}
}
