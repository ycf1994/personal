package com.tongniu.loan.view.dao;

import java.util.List;

import com.tongniu.loan.view.domain.ShowAccount;

public interface ShowAccountDao {
	List<ShowAccount> getAllShowAccountByPageAndRow(int start,int row);
	
	int getAllShowAccountCount();
	
	List<ShowAccount> searchAccount(int start,int row,String value);
	
	int getSearchCount(String value);
}
