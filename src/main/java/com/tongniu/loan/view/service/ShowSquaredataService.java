package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowSquaredataDao;
import com.tongniu.loan.view.domain.ShowSquaredata;

@Service(value = "showSquaredateService")
public class ShowSquaredataService {
	@Resource
	private ShowSquaredataDao showSquaredataDao;

	public List<ShowSquaredata> getAllShowSquaredataList(int page, int rows) {
		return showSquaredataDao.getAllShowSquaredataList((page - 1) * rows, rows);
	}

	public int getAllShowSquaredataListCount() {
		return showSquaredataDao.getAllShowSquaredataListCount();
	}

	public List<ShowSquaredata> searchShowSquaredata(String cust_name, int page, int rows) {
		return showSquaredataDao.searchShowSquaredata(cust_name, (page - 1) * rows, rows);
	}

	public int searchShowSquaredataCount(String cust_name) {
		return showSquaredataDao.searchShowSquaredataCount(cust_name);
	}
}
