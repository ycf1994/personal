package com.tongniu.loan.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.business.dao.UserCarryDao;
import com.tongniu.loan.business.domain.UserCarry;

@Service
public class UserCarryService {
	@Resource
	private UserCarryDao dao;

	public boolean addUserCarry(UserCarry userCarry) {
		return dao.addUserCarry(userCarry) > 0;
	}

	public List<UserCarry> findUserCarryByUser_id(Integer user_id) {
		return dao.findUserCarryByUser_id(user_id);
	}

	public List<UserCarry> findUserCarry_Rows(String searchValue,int status ,int page, int rows)

	{
		return dao.findUserCarry_Rows(searchValue,status, (page - 1) * rows, rows);
	}

	public int findUserCarry_Total(String searchValue,int status) {
		return dao.findUserCarry_Total(searchValue,status);
	}

	public int check(int status, int id) {
		return dao.check(status, id);
	}
}
