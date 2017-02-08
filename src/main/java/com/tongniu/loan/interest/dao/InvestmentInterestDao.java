package com.tongniu.loan.interest.dao;

import java.util.List;

import com.tongniu.loan.interest.domain.InvestmentInterest;

public interface InvestmentInterestDao {
	/**
	 * 根据用户Id查询每笔资金每个合同的投资利息记录
	 */
	List<InvestmentInterest> findInvestmentInterestsByUser_id(Integer user_id);

	/**
	 * 根据合同ID查询每个合同的投资利息记录
	 */
	List<InvestmentInterest> findInvestmentInterestsByContract_no(String contract_no);

	/**
	 * 根据资金ID查询投资利息记录
	 */
	List<InvestmentInterest> findInvestmentInterestByInvestment_account_no(String investment_account_no);
}
