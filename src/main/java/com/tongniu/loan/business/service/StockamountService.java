package com.tongniu.loan.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.business.dao.StockamountDao;
import com.tongniu.loan.business.domain.Stockamount;

@Service(value = "stockamountService")
public class StockamountService {
	@Resource
	private StockamountDao stockamountDao;

	/**
	 * 根据客户ID查询股票持有总数
	 */
	public List<Stockamount> getStockamountListByCust_id(Integer cust_id) {
		return stockamountDao.getStockamountListByCust_id(cust_id);
	}
	/**
	 * 根据资金账户ID查询股票持有总数
	 * */
	public List<Stockamount> getStockamountListByFund_id(Integer fund_id){
		return stockamountDao.getStockamountListByFund_id(fund_id);
	}
	
	public List<Stockamount> searchStockamout(Integer fund_id,int page,int rows){
		return stockamountDao.searchStockamout(fund_id, (page-1)*rows, rows);
	}
	public int searchStockamoutCount(Integer fund_id){
		return stockamountDao.searchStockamoutCount(fund_id);
	}
}
