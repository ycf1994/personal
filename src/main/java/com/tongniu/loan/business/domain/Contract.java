package com.tongniu.loan.business.domain;

/**
 * 合同
 */
public class Contract {
	/**
	 * 唯一标识
	 */
	private Integer id;
	/**
	 * 合同编号
	 */
	private String contract_no;
	/**
	 * 资金编号
	 */
	private String investment_account_no;
	/**
	 * 出资客户编号
	 */
	private Integer user_id;
	/**
	 * 借款客户编号
	 */
	private Integer cust_id;
	/**
	 * 出资金额
	 */
	private Double contract_money;
	/**
	 * 签署日期
	 */
	private String sign_date;
	/**
	 * 开始时间
	 */
	private String start_date;
	/**
	 * 结束时间
	 */
	private String end_date;
	/**
	 * 投资利率
	 */
	private Double investment_rate;
	/**
	 * 资金账户ID
	 */
	private Integer fund_id;
	/**
	 * 资金账户名称
	 */
	private String fund_acc;
	/**
	 * 审核标志：0.未审核 1.已审核 2.投资中 3.合同结清 4.作废
	 */
	private Integer states;
	/**
	 * 审核时间
	 */
	private String check_time;
	/**
	 * 审核人
	 */
	private String check_name;
	/**
	 * 完结时间
	 */
	private String wanjie_time;
	/**
	 * 是否强迫终止（-1-终止 1 正常）
	 */
	private Integer iscontinue;
	/**
	 * 合同录入时间
	 */
	private String input_time;
	/**
	 * 预期收益
	 */
	private Double invest_gain;
	/**
	 * 累计收益
	 */
	private Double sum_gain;
	/**
	 * 保证金
	 * */
	private Double earnest_money;
	/**
	 * 总金额
	 * */
	private Double sum_money;
	
	public Double getEarnest_money() {
		return earnest_money;
	}
	public void setEarnest_money(Double earnest_money) {
		this.earnest_money = earnest_money;
	}
	public Double getSum_money() {
		return sum_money;
	}
	public void setSum_money(Double sum_money) {
		this.sum_money = sum_money;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public Double getContract_money() {
		return contract_money;
	}
	public void setContract_money(Double contract_money) {
		this.contract_money = contract_money;
	}
	public String getSign_date() {
		return sign_date;
	}
	public void setSign_date(String sign_date) {
		this.sign_date = sign_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public Double getInvestment_rate() {
		return investment_rate;
	}
	public void setInvestment_rate(Double inverstment_rate) {
		this.investment_rate = inverstment_rate;
	}
	public Integer getFund_id() {
		return fund_id;
	}
	public void setFund_id(Integer fund_id) {
		this.fund_id = fund_id;
	}
	public String getFund_acc() {
		return fund_acc;
	}
	public void setFund_acc(String fund_acc) {
		this.fund_acc = fund_acc;
	}
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public String getWanjie_time() {
		return wanjie_time;
	}
	public void setWanjie_time(String wanjie_time) {
		this.wanjie_time = wanjie_time;
	}
	public Integer getIscontinue() {
		return iscontinue;
	}
	public void setIscontinie(Integer iscontinue) {
		this.iscontinue = iscontinue;
	}
	public String getInput_time() {
		return input_time;
	}
	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}
	public Double getInvest_gain() {
		return invest_gain;
	}
	public void setInvert_gain(Double invest_gain) {
		this.invest_gain = invest_gain;
	}
	public Double getSum_gain() {
		return sum_gain;
	}
	public void setSum_gain(Double sum_gain) {
		this.sum_gain = sum_gain;
	}
	public String getInvestment_account_no() {
		return investment_account_no;
	}
	public void setInvestment_account_no(String investment_account_no) {
		this.investment_account_no = investment_account_no;
	}
	public void setIscontinue(Integer iscontinue) {
		this.iscontinue = iscontinue;
	}
	public void setInvest_gain(Double invest_gain) {
		this.invest_gain = invest_gain;
	}
	public Contract(Integer id, String contract_no, String investment_account_no, Integer user_id, Integer cust_id,
			Double contract_money, String sign_date, String start_date, String end_date, Double investment_rate,
			Integer fund_id, String fund_acc, Integer states, String check_time, String check_name, String wanjie_time,
			Integer iscontinue, String input_time, Double invest_gain, Double sum_gain) {
		super();
		this.id = id;
		this.contract_no = contract_no;
		this.investment_account_no = investment_account_no;
		this.user_id = user_id;
		this.cust_id = cust_id;
		this.contract_money = contract_money;
		this.sign_date = sign_date;
		this.start_date = start_date;
		this.end_date = end_date;
		this.investment_rate = investment_rate;
		this.fund_id = fund_id;
		this.fund_acc = fund_acc;
		this.states = states;
		this.check_time = check_time;
		this.check_name = check_name;
		this.wanjie_time = wanjie_time;
		this.iscontinue = iscontinue;
		this.input_time = input_time;
		this.invest_gain = invest_gain;
		this.sum_gain = sum_gain;
	}
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contract [id=" + id + ", contract_no=" + contract_no + ", investment_account_no="
				+ investment_account_no + ", user_id=" + user_id + ", cust_id=" + cust_id + ", contract_money="
				+ contract_money + ", sign_date=" + sign_date + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", investment_rate=" + investment_rate + ", fund_id=" + fund_id + ", fund_acc=" + fund_acc
				+ ", states=" + states + ", check_time=" + check_time + ", check_name=" + check_name + ", wanjie_time="
				+ wanjie_time + ", iscontinue=" + iscontinue + ", input_time=" + input_time + ", invest_gain="
				+ invest_gain + ", sum_gain=" + sum_gain + "]";
	}


}
