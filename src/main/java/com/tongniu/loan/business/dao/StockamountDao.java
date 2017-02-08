package com.tongniu.loan.business.dao;

import java.util.List;

import com.tongniu.loan.business.domain.Stockamount;

public interface StockamountDao {
	/**
	 * 根据客户ID查询股票持有总数
	 * */
	List<Stockamount> getStockamountListByCust_id(Integer cust_id);
	
	/**
	 * 根据资金账户ID查询股票持有总数
	 * */
	List<Stockamount> getStockamountListByFund_id(Integer fund_id);
	
	List<Stockamount> searchStockamout(Integer fund_id,int start,int rows);
	int searchStockamoutCount(Integer fund_id);

}
