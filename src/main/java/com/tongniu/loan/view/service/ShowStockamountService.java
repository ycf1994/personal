package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowStockamountDao;
import com.tongniu.loan.view.domain.ShowStockamount;

@Service(value = "showStockamountService")
public class ShowStockamountService {
	@Resource
	private ShowStockamountDao showStockamountDao;

	public List<ShowStockamount> getAllShowStockamountList(int page, int rows) {
		return showStockamountDao.getAllShowStockamountList((page - 1) * rows, rows);
	}

	public int getAllShowStockamountListCount() {
		return showStockamountDao.getAllShowStockamountListCount();
	}

	public List<ShowStockamount> searchShowStockamount(String cust_name, int page, int rows) {
		return showStockamountDao.searchShowStockamount(cust_name, (page - 1) * rows, rows);
	}

	public int searchShowStockamountCount(String cust_name) {
		return showStockamountDao.searchShowStockamountCount(cust_name);
	}
}
