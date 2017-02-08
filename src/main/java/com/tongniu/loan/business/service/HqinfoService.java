package com.tongniu.loan.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.business.dao.HqinfoDao;
import com.tongniu.loan.business.domain.Hqinfo;

@Service
public class HqinfoService {
	@Resource
	private HqinfoDao hqinfoDao;

	public boolean add(Hqinfo hqinfo) {
		return hqinfoDao.add(hqinfo) > 0;
	}

	public boolean find(String stock_code) {
		return hqinfoDao.find(stock_code) > 0;
	};

	public boolean update(Hqinfo hqinfo) {
		return hqinfoDao.update(hqinfo) > 0;
	}

	public List<Hqinfo> findHqinfoList_Rows(String codeOrName, int hq_date, int page, int rows) {
		return hqinfoDao.findHqinfoList_Rows(codeOrName, hq_date, (page - 1) * rows, rows);
	}

	public int findHqinfoList_Total(String codeOrName, int hq_date) {
		return hqinfoDao.findHqinfoList_Total(codeOrName, hq_date);
	}
}
