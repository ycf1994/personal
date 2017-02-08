package com.tongniu.loan.view.dao;

import java.util.List;

import com.tongniu.loan.view.domain.ShowSquaredata;

public interface ShowSquaredataDao {
	List<ShowSquaredata> getAllShowSquaredataList(int start,int rows);
	int getAllShowSquaredataListCount();
	List<ShowSquaredata> searchShowSquaredata(String cust_name,int start,int rows);
	int searchShowSquaredataCount(String cust_name);
}
