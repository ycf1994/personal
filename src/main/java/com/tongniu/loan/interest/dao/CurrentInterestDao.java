package com.tongniu.loan.interest.dao;

import java.util.List;

import com.tongniu.loan.interest.domain.CurrentInterest;

public interface CurrentInterestDao {
	/**
	 * 根据用户ID查询每天的每笔资金的活期收益
	 */
	List<CurrentInterest> findCurrentInterestsByUser_id(Integer user_id);

	/**
	 * 根据资金编号查询 某一笔资金的收益
	 */
	List<CurrentInterest> findCurrentInterestsByInvestment_account_no(String investment_account_no);

}
