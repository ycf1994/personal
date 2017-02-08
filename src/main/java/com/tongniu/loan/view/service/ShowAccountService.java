package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowAccountDao;
import com.tongniu.loan.view.domain.ShowAccount;

@Service(value = "showAccountService")
public class ShowAccountService {
	
	
	@Resource
	private ShowAccountDao showAccountDao;

	public List<ShowAccount> getAllShowAccount(int page,int row) {
		return showAccountDao.getAllShowAccountByPageAndRow((page-1)*row,row);
	}
	
	public int getAllShowAccountCount(){
		return showAccountDao.getAllShowAccountCount();
	}
	
	public List<ShowAccount> searchAccount(int page,int rows,String value){
		return showAccountDao.searchAccount((page-1)*rows, rows, value);
	}
	
	public int getSearchCount(String value){
		return showAccountDao.getSearchCount(value);
	}
}
