package com.tongniu.loan.account.dao;

import com.tongniu.loan.account.domain.Account;

public interface AccountDao {
	/**
	 * 根据用户ID查询资金账户信息
	 * */
	Account findAccountByUser_id(Integer user_id);
}
