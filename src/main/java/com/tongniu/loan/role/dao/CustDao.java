package com.tongniu.loan.role.dao;

import java.util.List;

import com.tongniu.loan.role.domain.Cust;

public interface CustDao {
	/**
	 * 根据ID查询借款客户信息
	 */
	Cust getCustById(Integer id);

	/**
	 * 查询全部借款用户信息
	 */
	List<Cust> getCustList(int start, int rows);

	int getCustListCount();

	List<Cust> searchCust(int start, int rows, String realname);

	int searchCustCount(String realname);

	Integer getIdByRealnameAndIdno(String realname, String idno);

	int addCust(Cust cust);
	
	List<Cust> getAllCustList();

}
