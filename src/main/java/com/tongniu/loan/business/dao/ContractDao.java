package com.tongniu.loan.business.dao;

import java.util.List;

import com.tongniu.loan.business.domain.Contract;

public interface ContractDao {
	/**
	 * 添加合同
	 */
	int addContract(Contract contract);

	/**
	 * 根据出资者ID查询合同
	 */
	List<Contract> getContractsByUser_id(Integer user_id);

	/**
	 * 根据借款者ID查询合同
	 */
	List<Contract> getContractsByCust_id(Integer cust_id);

	/**
	 * 根据资金编号查询合同
	 */
	List<Contract> getContractByInvestment_account_no(String investment_account_no);

	/**
	 * 查询全部合同
	 */
	List<Contract> getContracts();

	/**
	 * 查询各种状态的合同
	 */
	List<Contract> getNeedContracts(Integer states);

	/**
	 * 合同状态更改
	 */
	int updateStates(Contract contract);

	List<Contract> searchContract(String investment_account_no, int start, int rows);

	int searchContractCount(String investment_account_no);

	List<Contract> getNeewContractListByUser_id(Integer user_id, Integer contractType);

	Contract getContractByContractId(Integer id);

	int changeStateByBackMoney(String contract_no);

	String getInvestment_account_noByContract_no(String contract_no);

	String getTfund(Integer id);

	int updateFund_no(String contract_no);

	Contract getContractByContract_no(String contract_no);

	int zuofeihuikuan(String contract_no);

	List<Contract> getContractsByFund_id(int fund_id,int start,int rows);
	
	int getContractsByFund_id_Count(int fund_id);
	
	int querenhuikuan(String contract_no);
	
	int rateToaccountInsertFlow(String contract_no);
	
	int  checkSameContract_no(String contract_no);
	
	
	String getTfundByContract_no(String contract_no);

}
