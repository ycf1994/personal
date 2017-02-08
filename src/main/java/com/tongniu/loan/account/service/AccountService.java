package com.tongniu.loan.account.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.account.dao.AccountDao;
import com.tongniu.loan.account.domain.Account;

@Service(value = "accountService")
public class AccountService {
	@Resource
	private AccountDao accountDao;

	/**
	 * 根据用户ID查询资金账户信息
	 */
	public Account findAccountByUser_id(Integer user_id) {
		return accountDao.findAccountByUser_id(user_id);
	}
}
