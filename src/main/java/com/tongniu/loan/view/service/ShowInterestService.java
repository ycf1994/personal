package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowInterestDao;
import com.tongniu.loan.view.domain.ShowInterest;

@Service(value = "showInterestService")
public class ShowInterestService {
	@Resource
	private ShowInterestDao showInterestDao;

	public List<ShowInterest> getAllShowInterestList(int page, int rows) {
		return showInterestDao.getAllShowInterestList((page - 1) * rows, rows);
	}

	public int getAllShowInterestListCount() {
		return showInterestDao.getAllShowInterestListCount();
	}

	public List<ShowInterest> searchShowInterest(int page, int rows, String value) {
		return showInterestDao.searchShowInterest((page - 1) * rows, rows, value);
	}

	public int searchShowInterestCount(String value) {
		return showInterestDao.searchShowInterestCount(value);
	}

}
