package com.tongniu.loan.account.dao;

import java.util.List;

import com.tongniu.loan.account.domain.Tfundacct;

public interface TfundacctDao {

	List<Tfundacct> getTfundacctList(int start, int rows);

	int getTfundacctListCount();

	List<Tfundacct> getTfundacctListByCust_name(int start, int rows, String cust_name);

	int getTfundacctListByCust_nameCount(String cust_name);
	
	List<Tfundacct> getAllTfundacctListByCust_name(String cust_name);
	
	int backMoney(int fund_id,Double contract_money);
	
	int checkStockIsEmpty(int fund_id);
	
	List<String> getStock(int fund_id,String contract_no);
	
	
	
	
	int addTfundacct(int fund_id,String fund_acc,int cust_id,String contract_no,double contract_money,double sum_money);
	
	String checkSame(int cust_id,String tfund_acct);
	
	/**
	 * 回款
	 * */
	int tfundacctBack(int fund_id,double money,String contract_no);
	/**
	 * 撤销回款
	 * */
	int cancelBack(int fun_id,double money,String contract_no);
}
