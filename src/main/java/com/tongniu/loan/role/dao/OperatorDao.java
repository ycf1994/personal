package com.tongniu.loan.role.dao;

import java.util.List;

import com.tongniu.loan.role.domain.Operator;

public interface OperatorDao {
	int add(Operator operator);

	int delete(int id);

	int update(Operator operator);

	int update_login_time(int id);

	List<Operator> find_rows(String value, int start, int rows);

	int find_count(String value);

	Operator login(String username, String password);
	
	int checkSame(String username);
}
