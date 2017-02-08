package com.tongniu.loan.business.dao;

import java.util.List;

import com.tongniu.loan.business.domain.Tstockinfo;

public interface TstockinfoDao {
	/**
	 * 根据股票代码 查询股票信息
	 */
	Tstockinfo getTstockinfoByStock_code(String stock_code);

	/**
	 * 查询全部股票信息
	 */
	List<Tstockinfo> getAllTstockinfoList(int start, int rows);

	int getAllTstockinfoListCount();

	List<Tstockinfo> searchTstockinfo(String value, int start, int rows);

	int searchTstockinfoCount(String value);
	
	List<Tstockinfo> getStockList(String value);
	
	List<Tstockinfo> getAllTstockinfo();
	
	int addTstockinfo(Tstockinfo tstockinfo);
	
	List<Tstockinfo> findStocks(String value);
}
