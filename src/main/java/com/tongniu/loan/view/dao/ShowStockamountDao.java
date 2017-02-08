package com.tongniu.loan.view.dao;

import java.util.List;

import com.tongniu.loan.view.domain.ShowStockamount;

public interface ShowStockamountDao {
	List<ShowStockamount> getAllShowStockamountList(int start,int rows);
	int getAllShowStockamountListCount();
	
	List<ShowStockamount> searchShowStockamount(String cust_name,int start,int rows);
	int searchShowStockamountCount(String cust_name);
}
