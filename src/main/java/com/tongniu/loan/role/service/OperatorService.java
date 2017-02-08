package com.tongniu.loan.role.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.role.dao.OperatorDao;
import com.tongniu.loan.role.domain.Operator;

@Service
public class OperatorService {
	@Resource
	private OperatorDao operatorDao;

	public boolean add(Operator operator) {
		return operatorDao.add(operator) > 0;
	}

	public boolean delete(int id) {
		return operatorDao.delete(id) > 0;
	}

	public boolean update(Operator operator) {
		return operatorDao.update(operator) > 0;
	}

	public boolean update_login_time(int id) {
		return operatorDao.update_login_time(id) > 0;
	}

	public List<Operator> find_rows(String value, int page, int rows) {
		return operatorDao.find_rows(value, (page - 1) * rows, rows);
	}

	public int find_count(String value) {
		return operatorDao.find_count(value);
	}

	public Operator login(String username, String password) {
		return operatorDao.login(username, password);
	}
	
	public boolean checkSame(String username){
		return operatorDao.checkSame(username)<1;
	}
}
