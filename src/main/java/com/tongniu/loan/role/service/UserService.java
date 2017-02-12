package com.tongniu.loan.role.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.role.dao.UserDao;
import com.tongniu.loan.role.domain.User;

@Service(value = "userService")
public class UserService {
	@Resource
	private UserDao userDao;

	/**
	 * 注册用户
	 */
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user) > 0;
	}

	public boolean delUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.delUser(id) > 0;
	}

	/**
	 * 更新用户
	 */
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user) > 0;
	}

	/**
	 * 查询全部用户信息
	 */
	public List<User> findUser() {
		// TODO Auto-generated method stub
		return userDao.findUser();
	}

	/**
	 * 登录验证
	 */
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.login(username, password);
	}

	/**
	 * 更新最近登录时间
	 */
	public boolean updateLogin_time(String input_time, Integer id) {
		// TODO Auto-generated method stub
		return userDao.updateLogin_time(input_time, id) > 0;
	}

	/**
	 * 修改密码
	 */
	public boolean modifyPassword(String password, Integer id) {
		return userDao.modifyPassword(password, id) > 0;
	}

	/**
	 * 分页查询用户信息
	 */
	public List<User> findUserByPageAndRow(int page, int row) {
		return userDao.findUserByPageAndRow((page - 1) * row, row);
	}

	/**
	 * 获取用户总数
	 */
	public int getUserCount() {
		return userDao.getUserCount();
	}

	public List<User> searchUser(String value, int page, int rows) {
		return userDao.searchUser(value, (page - 1) * rows, rows);
	}

	public int searchUserCount(String value) {
		return userDao.searchUserCount(value);
	}

	public Integer getIdByUsername(String username) {
		return userDao.getIdByUsername(username);
	}

	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	public User doLogin(String mobile, String password) {
		return userDao.doLogin(mobile, password);
	}

	public double getYestodayGain(Integer id) {
		return userDao.getYestodayGain(id);
	}

	public double getInvestmoney(Integer id) {
		return userDao.getInvestmoney(id);
	}

	public List<String> getEveryDayGain(Integer id) {
		return userDao.getEveryDayGain(id);
	}

	public double getLeiji(Integer id) {
		return userDao.getLeiji(id);
	}

	public double getYestodayYueGain(Integer id) {
		return userDao.getYestodayYueGain(id);
	}

	public double getYueLeiji(Integer id) {
		return userDao.getYueLeiji(id);
	}

	public String getTixianBankinfo(Integer id) {
		return userDao.getTixianBankinfo(id);
	}

	public boolean setPwd(String newPwd, String phone) {
		return userDao.setPwd(newPwd, phone) > 0;
	}

	public boolean getMobileCount(String phone) {
		return userDao.getMobileCount(phone) <= 0;
	}

	public List<String> getQiRiNianhua(Integer id) {
		return userDao.getQiRiNianhua(id);
	}

	public boolean setPattern_lock(String pattern_lock, String id) {
		return userDao.setPattern_lock(pattern_lock, id) > 0;
	}

	public String getPattern_lock(String id) {
		return userDao.getPattern_lock(id);
	}
	
public User getUserBySaltId(String token){
	return userDao.getUserBySaltId(token);
}
	
	public double getYestodayGainBySaltId(String token){
		return userDao.getYestodayGainBySaltId(token);
	}
	public double getInvestMoneyBySaltId(String token){
		return userDao.getInvestMoneyBySaltId(token);
	}
	
	public double getLeijiBySaltId(String token){
		return userDao.getLeijiBySaltId(token);
	}
	
	public List<String> getEveryDayGainBySaltId(String token){
		return userDao.getEveryDayGainBySaltId(token);
	}
	
	public List<String> getQiRiNianhuaBySaltId(String token){
		return userDao.getQiRiNianhuaBySaltId(token);
	}
	
	public String getTixianBankinfoBySaltId(String token){
		return userDao.getTixianBankinfoBySaltId(token);
	}
	


}
