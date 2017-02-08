package com.tongniu.loan.account.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.account.dao.TfundacctDao;
import com.tongniu.loan.account.domain.Tfundacct;

@Service(value = "tfundacctService")
public class TfundacctService {
	@Resource
	private TfundacctDao tfundaccDao;

	public List<Tfundacct> getTfundacctList(int page, int rows) {
		// TODO Auto-generated method stub
		return tfundaccDao.getTfundacctList((page - 1) * rows, rows);
	}

	public int getTfundacctListCount() {
		// TODO Auto-generated method stub
		return tfundaccDao.getTfundacctListCount();
	}

	public List<Tfundacct> getTfundacctListByCust_name(int page, int rows, String cust_name) {
		// TODO Auto-generated method stub
		return tfundaccDao.getTfundacctListByCust_name((page - 1) * rows, rows, cust_name);
	}

	public int getTfundacctListByCust_nameCount(String cust_name) {
		// TODO Auto-generated method stub
		return tfundaccDao.getTfundacctListByCust_nameCount(cust_name);
	}

	public List<Tfundacct> getAllTfundacctListByCust_name(String cust_name) {
		// TODO Auto-generated method stub
		return tfundaccDao.getAllTfundacctListByCust_name(cust_name);
	}

	public boolean backMoney(int fund_id, Double contract_money) {
		return tfundaccDao.backMoney(fund_id, contract_money) > 0;
	}

	public boolean checkStockIsEmpty(int fund_id) {
		return tfundaccDao.checkStockIsEmpty(fund_id) == 0;
	}

	public List<String> getStock(int fund_id, String contract_no) {
		return tfundaccDao.getStock(fund_id, contract_no);
	}

	public boolean addTfundacct(int fund_id, String fund_acc, int cust_id, String contract_no, double contract_money,double sum_money) {
		return tfundaccDao.addTfundacct(fund_id, fund_acc, cust_id, contract_no, contract_money,sum_money) > 0;
	}

	public String checkSame(int cust_id, String tfund_acct) {
		return tfundaccDao.checkSame(cust_id, tfund_acct);
	}

	public boolean tfundacctBack(int fund_id, double money, String contract_no) {
		int count = tfundaccDao.tfundacctBack(fund_id, money, contract_no);
		System.out.println(count);
		return count > 0;
	}
	
	/**
	 * 撤销回款
	 * */
	public boolean  cancelBack(int fun_id,double money,String contract_no){
		int count=tfundaccDao.cancelBack(fun_id, money, contract_no);
		System.out.println(count);
		return count>0;
	}

}
