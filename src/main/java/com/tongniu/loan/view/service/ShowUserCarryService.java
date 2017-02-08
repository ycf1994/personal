package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowUserCarryDao;
import com.tongniu.loan.view.domain.ShowUserCarry;

@Service
public class ShowUserCarryService {
	@Resource
	private ShowUserCarryDao showUserCarryDao;
	
public List<ShowUserCarry> findShowUserCarry_Rows(String searchValue,int status,int page,int rows){
	return showUserCarryDao.findShowUserCarry_Rows(searchValue, status,(page-1)*rows, rows);
}
	
	public int findShowUserCarry_Total(String searchValue,int status){
		return showUserCarryDao.findShowUserCarry_Total(searchValue, status);
	}
}
