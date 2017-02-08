package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowTfundacctDao;
import com.tongniu.loan.view.domain.ShowTfundacct;

@Service(value = "showTfundacctService")
public class ShowTfundacctService {
	@Resource
	private ShowTfundacctDao showTfundacctDao;

	public List<ShowTfundacct> getAllShowTfundacctList() {
		return showTfundacctDao.getAllShowTfundacctList();
	}
	
	public List<ShowTfundacct> getAllShowTfundacctList2() {
		return showTfundacctDao.getAllShowTfundacctList2();
	}
}
