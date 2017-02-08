package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowFlowDao;
import com.tongniu.loan.view.domain.ShowFlow;

@Service
public class ShowFlowService {
	@Resource
	private ShowFlowDao showFlowDao;

	public List<ShowFlow> getAllShowFlowList(int page, int rows) {
		// TODO Auto-generated method stub
		return showFlowDao.getAllShowFlowList((page - 1) * rows, rows);
	}

	public int getAllShowFlowListCount() {
		// TODO Auto-generated method stub
		return showFlowDao.getAllShowFlowListCount();
	}

	public List<ShowFlow> searchShowFlow(String value, int flag, int page, int rows) {
		// TODO Auto-generated method stub
		return showFlowDao.searchShowFlow(value, flag, (page - 1) * rows, rows);
	}

	public int searchShowFlowCount(String value, int flag) {
		// TODO Auto-generated method stub
		return showFlowDao.searchShowFlowCount(value, flag);
	}

}
