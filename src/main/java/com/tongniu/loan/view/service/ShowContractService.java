package com.tongniu.loan.view.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.view.dao.ShowContractDao;
import com.tongniu.loan.view.domain.ShowContract;

@Service(value = "showContractService")
public class ShowContractService {
	@Resource
	private ShowContractDao showContractDao;

	public final List<ShowContract> findShowContractListByInvestment_account_no(String investment_account_no) {
		return showContractDao.findShowContractListByInvestment_account_no(investment_account_no);
	}

	public final List<ShowContract> getAllShowContractList(int page, int rows) {
		return showContractDao.getAllShowContractList((page - 1) * rows, rows);
	}

	public final List<ShowContract> findNeewedShowContractList(Integer states) {
		return showContractDao.findNeewedShowContractList(states);
	}

	public final int getAllShowContractListCount() {
		return showContractDao.getAllShowContractListCount();
	}

	public final List<ShowContract> searchShowContract(int page, int rows, String user, String cust) {
		return showContractDao.searchShowContract((page - 1) * rows, rows, user, cust);
	}

	public final int searchShowContractCount(String user, String cust) {
		return showContractDao.searchShowContractCount(user, cust);
	}

	public List<ShowContract> getAllUncheckedShowContractList(int page, int rows) {
		return showContractDao.getAllUncheckedShowContractList((page - 1) * rows, rows);
	}

	public int getAllUncheckedShowContractListCount() {
		return showContractDao.getAllUncheckedShowContractListCount();
	}

	public List<ShowContract> getShowContractsByFund_id(int fund_id, int page, int rows) {
		return showContractDao.getShowContractsByFund_id(fund_id, (page - 1) * rows, rows);
	}

	public int getShowContractsByFund_id_Count(int fun_id) {
		return showContractDao.getShowContractsByFund_id_Count(fun_id);
	}

	public boolean checkStart_date(String investment_account_no, String start_date) {
		return showContractDao.checkStart_date(investment_account_no, start_date) > 0;
	}
}
