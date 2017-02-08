package com.tongniu.loan.view.dao;

import java.util.List;

import com.tongniu.loan.view.domain.ShowInvestment_account;

public interface ShowInvestment_accountDao {
	List<ShowInvestment_account> getAllShowInvestment_accountList(int start,int rows);
	int getAllShowInvestment_accountListCount();
	
	
	List<ShowInvestment_account> searchShowInvestment_account(String value,int start,int rows);
	int searchShowInvestment_accountCount(String value);
}
