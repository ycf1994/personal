package com.tongniu.loan.business.dao;

import java.util.List;

import com.tongniu.loan.business.domain.UserCarry;

public interface UserCarryDao {
	int addUserCarry(UserCarry userCarry);
	
	List<UserCarry> findUserCarryByUser_id(Integer user_id);
	
	List<UserCarry> findUserCarry_Rows(String searchValue,int status,int start,int rows);
	
	int findUserCarry_Total(String searchValue,int status);
	
	int check(int status,int id);
}
