package com.tongniu.loan.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.business.dao.ContractDao;
import com.tongniu.loan.business.domain.Contract;

@Service(value = "contractService")
public class ContractService {
	@Resource
	private ContractDao contractDao;

	/**
	 * 添加合同
	 */
	public boolean addContract(Contract contract) {
		// TODO Auto-generated method stub
		return contractDao.addContract(contract) > 0;
	}

	/**
	 * 根据出资者ID查询合同
	 */
	public List<Contract> getContractsByUser_id(Integer user_id) {
		// TODO Auto-generated method stub
		return contractDao.getContractsByUser_id(user_id);
	}

	/**
	 * 根据借款者ID查询合同
	 */
	public List<Contract> getContractsByCust_id(Integer cust_id) {
		// TODO Auto-generated method stub
		return contractDao.getContractsByCust_id(cust_id);
	}

	/**
	 * 根据资金编号查询合同
	 */
	public List<Contract> getContractByInvestment_account_no(String investment_account_no) {
		// TODO Auto-generated method stub
		return contractDao.getContractByInvestment_account_no(investment_account_no);
	}

	/**
	 * 查询全部合同
	 */
	public List<Contract> getContracts() {
		return contractDao.getContracts();
	}

	/**
	 * 查询各种状态的合同
	 */
	public List<Contract> getNeedContracts(Integer states) {
		return contractDao.getNeedContracts(states);
	}

	/**
	 * 更改合同状态
	 */
	public boolean updateStates(Contract contract) {
		return contractDao.updateStates(contract) > 0;
	}

	public List<Contract> searchContract(String investment_account_no, int page, int rows) {
		return contractDao.searchContract(investment_account_no, (page - 1) * rows, rows);
	}

	public int searchContractCount(String investment_account_no) {
		return contractDao.searchContractCount(investment_account_no);
	}

	public List<Contract> getNeewContractListByUser_id(Integer user_id, Integer contractType) {
		return contractDao.getNeewContractListByUser_id(user_id, contractType);
	}

	public Contract getContractByContractId(Integer contractId) {
		return contractDao.getContractByContractId(contractId);
	}

	public boolean changeStateByBackMoney(String contract_no) {
		return contractDao.changeStateByBackMoney(contract_no) > 0;
	}

	public String getInvestment_account_noByContract_no(String contract_no) {
		return contractDao.getInvestment_account_noByContract_no(contract_no);
	}

	public String getTfund(Integer id) {
		return contractDao.getTfund(id);
	}

	public boolean updateFund_no(String contract_no) {
		return contractDao.updateFund_no(contract_no) > 0;
	}

	public Contract getContractByContract_no(String contract_no) {
		return contractDao.getContractByContract_no(contract_no);
	}

	public boolean zuofeihuikuan(String contract_no) {
		return contractDao.zuofeihuikuan(contract_no) > 0;
	}

	public List<Contract> getContractsByFund_id(int fund_id, int page, int rows) {
		return contractDao.getContractsByFund_id(fund_id, (page - 1) * rows, rows);
	}

	public int getContractsByFund_id_Count(int fund_id) {
		return contractDao.getContractsByFund_id_Count(fund_id);
	}

	public boolean querenhuikuan(String contract_no) {
		return contractDao.querenhuikuan(contract_no) > 0;
	}

	public boolean rateToaccountInsertFlow(String contract_no) {
		return contractDao.rateToaccountInsertFlow(contract_no) > 0;
	}
	
	public boolean  checkSameContract_no(String contract_no){
		return contractDao.checkSameContract_no(contract_no)<=0;
	}
	
	public String getTfundByContract_no(String contract_no){
		return contractDao.getTfundByContract_no(contract_no);
	}
}
