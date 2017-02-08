package com.tongniu.loan.view.dao;

import java.util.List;

import com.tongniu.loan.view.domain.ShowContract;

public interface ShowContractDao {
	List<ShowContract> findShowContractListByInvestment_account_no(String investment_account_no);

	List<ShowContract> getAllShowContractList(int start, int rows);

	int getAllShowContractListCount();

	List<ShowContract> findNeewedShowContractList(Integer states);

	List<ShowContract> searchShowContract(int start, int rows, String user, String cust);

	int searchShowContractCount(String user, String cust);

	List<ShowContract> getAllUncheckedShowContractList(int start, int rows);

	int getAllUncheckedShowContractListCount();

	List<ShowContract> getShowContractsByFund_id(int fund_id, int start, int rows);

	int getShowContractsByFund_id_Count(int fun_id);
	
	int checkStart_date(String investment_account_no,String start_date);
}
