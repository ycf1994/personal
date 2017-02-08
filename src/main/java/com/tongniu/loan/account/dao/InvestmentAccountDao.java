package com.tongniu.loan.account.dao;

import java.util.List;

import com.tongniu.loan.account.domain.InvestmentAccount;

public interface InvestmentAccountDao {
	/**
	 * 添加投资记录
	 */
	int addInvestmentAccount(InvestmentAccount investmentAccount);

	/**
	 * 查看投资记录
	 */
	List<InvestmentAccount> getInvestmentAccountsByUser_id(Integer user_id);
	
	/**
	 * 
	 * */
	int backMoney(String investment_account_no,Double contract_money);
	
	/**
	 * checkInvestment_account_no
	 * */
	int checkInvestment_account_no(String investment_account_no);
}
