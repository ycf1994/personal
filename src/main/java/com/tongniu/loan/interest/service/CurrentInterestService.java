package com.tongniu.loan.interest.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.interest.dao.CurrentInterestDao;
import com.tongniu.loan.interest.domain.CurrentInterest;

@Service(value = "currentInterestService")
public class CurrentInterestService {
	@Resource
	private CurrentInterestDao currentInterestDao;

	/**
	 * 根据用户ID查询每天的每笔资金的活期收益
	 */
	public List<CurrentInterest> findCurrentInterestsByUser_id(Integer user_id) {
		// TODO Auto-generated method stub
		return currentInterestDao.findCurrentInterestsByUser_id(user_id);
	}

	/**
	 * 根据资金编号查询 某一笔资金的收益
	 */
	public List<CurrentInterest> findCurrentInterestsByInvestment_account_no(String investment_account_no) {
		// TODO Auto-generated method stub
		return currentInterestDao.findCurrentInterestsByInvestment_account_no(investment_account_no);
	}
}
