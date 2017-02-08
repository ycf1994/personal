package com.tongniu.loan.interest.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.interest.dao.InvestmentInterestDao;
import com.tongniu.loan.interest.domain.InvestmentInterest;

@Service(value = "investmentInterestService")
public class InvestmentInterestService {
	@Resource
	private InvestmentInterestDao investmentInterestDao;

	/**
	 * 根据用户Id查询每笔资金每个合同的投资利息记录
	 */
	public List<InvestmentInterest> findInvestmentInterestsByUser_id(Integer user_id) {
		// TODO Auto-generated method stub
		return investmentInterestDao.findInvestmentInterestsByUser_id(user_id);
	}

	/**
	 * 根据合同ID查询每个合同的投资利息记录
	 */
	public List<InvestmentInterest> findInvestmentInterestsByContract_no(String contract_no) {
		// TODO Auto-generated method stub
		return investmentInterestDao.findInvestmentInterestsByContract_no(contract_no);
	}

	/**
	 * 根据资金ID查询投资利息记录
	 */
	public List<InvestmentInterest> findInvestmentInterestByInvestment_account_no(String investment_account_no) {
		// TODO Auto-generated method stub
		return investmentInterestDao.findInvestmentInterestByInvestment_account_no(investment_account_no);
	}

}
