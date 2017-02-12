package com.tongniu.loan.role.dao;

import java.util.List;

import com.tongniu.loan.role.domain.User;

public interface UserDao {
	/**
	 * 注册用户
	 */
	int addUser(User user);

	/**
	 * 删除用户
	 */
	int delUser(Integer id);

	/**
	 * 更新用户
	 */
	int updateUser(User user);

	/**
	 * 查询全部用户信息
	 */
	List<User> findUser();

	/**
	 * 登录验证
	 */
	User login(String username, String password);

	/**
	 * 更新最近登录时间
	 */
	int updateLogin_time(String input_time, Integer id);

	/**
	 * 修改密码
	 */
	int modifyPassword(String password, Integer id);

	/**
	 * 分页查询用户信息
	 */
	List<User> findUserByPageAndRow(int start, int row);

	/**
	 * 获取用户总数
	 */
	int getUserCount();

	List<User> searchUser(String value, int start, int rows);

	int searchUserCount(String value);

	Integer getIdByUsername(String username);

	User getUserById(Integer id);

	User doLogin(String mobile, String password);

	double getYestodayGain(Integer id);

	double getInvestmoney(Integer id);

	List<String> getEveryDayGain(Integer id);

	double getLeiji(Integer id);

	double getYestodayYueGain(Integer id);

	double getYueLeiji(Integer id);

	/**
	 * 获取用户用于提现的银行卡和银行名称
	 */
	String getTixianBankinfo(Integer id);
	
	String getTixianBankinfoBySaltId(String token);
	
	
	int setPwd(String newPwd,String phone);
	
	
	int getMobileCount(String phone);
	
	List<String> getQiRiNianhua(Integer id);
	
	int setPattern_lock(String pattern_lock,String token);
	
	String getPattern_lock(String token);
	
	User getUserBySaltId(String token);
	
	double getYestodayGainBySaltId(String token);
	double getInvestMoneyBySaltId(String token);
	double getLeijiBySaltId(String token);
	List<String> getEveryDayGainBySaltId(String token);
	List<String> getQiRiNianhuaBySaltId(String token);

}
