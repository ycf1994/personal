package com.tongniu.loan.view.dao;

import java.util.List;

import com.tongniu.loan.view.domain.ShowUserCarry;

public interface ShowUserCarryDao {
List<ShowUserCarry> findShowUserCarry_Rows(String searchValue,int status,int start,int rows);
	
	int findShowUserCarry_Total(String searchValue,int status);
}
