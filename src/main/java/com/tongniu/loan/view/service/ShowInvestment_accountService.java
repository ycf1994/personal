package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowInvestment_accountDao;
import com.tongniu.loan.view.domain.ShowInvestment_account;

@Service(value="showInvestment_accountService")
public class ShowInvestment_accountService {
	@Resource
	private ShowInvestment_accountDao showInvestment_accountDao;
	
	public List<ShowInvestment_account> getAllShowInvestment_accountList(int page,int rows){
		return showInvestment_accountDao.getAllShowInvestment_accountList((page-1)*rows, rows);
	}
	public int getAllShowInvestment_accountListCount(){
		return showInvestment_accountDao.getAllShowInvestment_accountListCount();
	}
	
	
	public List<ShowInvestment_account> searchShowInvestment_account(String value,int page,int rows){
		return showInvestment_accountDao.searchShowInvestment_account(value, (page-1)*rows, rows);
	}
	public int searchShowInvestment_accountCount(String value){
		return showInvestment_accountDao.searchShowInvestment_accountCount(value);
	}
}
