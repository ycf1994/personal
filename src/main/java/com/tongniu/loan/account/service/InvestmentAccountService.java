package com.tongniu.loan.account.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.account.dao.InvestmentAccountDao;
import com.tongniu.loan.account.domain.InvestmentAccount;

@Service(value = "investmentAccountService")
public class InvestmentAccountService {

	@Resource
	private InvestmentAccountDao investmentAccountDao;

	/**
	 * 添加投资记录
	 */
	public boolean addInvestmentAccount(InvestmentAccount investmentAccount) {
		// TODO Auto-generated method stub
		return investmentAccountDao.addInvestmentAccount(investmentAccount) > 0;
	}

	/**
	 * 查看投资记录
	 */
	public List<InvestmentAccount> getInvestmentAccountsByUser_id(Integer user_id) {
		// TODO Auto-generated method stub
		return investmentAccountDao.getInvestmentAccountsByUser_id(user_id);
	}
	
	public boolean backMoney(String investment_account_no,Double contract_money){
		return investmentAccountDao.backMoney(investment_account_no, contract_money)>0;
	}
	
	public boolean checkInvestment_account_no(String investment_account_no){
		return investmentAccountDao.checkInvestment_account_no(investment_account_no)<=0;
	}

}
