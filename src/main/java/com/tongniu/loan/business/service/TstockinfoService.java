package com.tongniu.loan.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.business.dao.TstockinfoDao;
import com.tongniu.loan.business.domain.Tstockinfo;

@Service(value = "tstockinfoService")
public class TstockinfoService {
	@Resource
	private TstockinfoDao tstockinfoDao;

	/**
	 * 根据股票代码查询股票信息
	 */
	public Tstockinfo getTstockinfoByStock_code(String stock_code) {
		return tstockinfoDao.getTstockinfoByStock_code(stock_code);
	}

	/**
	 * 查询全部股票信息
	 */
	public List<Tstockinfo> getAllTstockinfoList(int page, int rows) {
		return tstockinfoDao.getAllTstockinfoList((page - 1) * rows, rows);
	}

	public int getAllTstockinfoListCount() {
		return tstockinfoDao.getAllTstockinfoListCount();
	}

	public List<Tstockinfo> searchTstockinfo(String value, int page, int rows) {
		return tstockinfoDao.searchTstockinfo(value, (page - 1) * rows, rows);
	}

	public int searchTstockinfoCount(String value) {
		return tstockinfoDao.searchTstockinfoCount(value);
	}

	public List<Tstockinfo> getStockList(String value) {
		return tstockinfoDao.getStockList(value);
	}

	public List<Tstockinfo> getAllTstockinfo() {
		return tstockinfoDao.getAllTstockinfo();
	}

	public boolean addTstockinfo(Tstockinfo tstockinfo) {
		return tstockinfoDao.addTstockinfo(tstockinfo) > 0;
	}

	public List<Tstockinfo> findStocks(String value) {
		return tstockinfoDao.findStocks(value);
	}
}
