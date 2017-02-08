package com.tongniu.loan.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.business.dao.FlowDao;
import com.tongniu.loan.business.domain.Flow;

@Service(value = "flowService")
public class FlowService {
	@Resource
	private FlowDao flowDao;

	/**
	 * 添加资金流水记录
	 */
	public boolean addFlow(Flow flow) {
		// TODO Auto-generated method stub
		return flowDao.addFlow(flow) > 0;
	}

	/**
	 * 根据用户ID查询资金流水记录
	 */
	public List<Flow> findFlowsByUser_id(Integer user_id) {
		// TODO Auto-generated method stub
		return flowDao.findFlowsByUser_id(user_id);
	}

	/**
	 * 根据用户ID查询资金提现记录
	 */
	public List<Flow> findCashFlowsByUser_id(Integer user_id) {
		// TODO Auto-generated method stub
		return flowDao.findCashFlowsByUser_id(user_id);
	}

	/**
	 * 根据用户ID查询资金入账记录
	 */
	public List<Flow> findRecordFlowsByUser_id(Integer user_id) {
		// TODO Auto-generated method stub
		return flowDao.findRecordFlowsByUser_id(user_id);
	}

	public List<Flow> getFlowListByUser_id(Integer user_id, int page, int rows) {
		return flowDao.getFlowListByUser_id(user_id, (page - 1) * rows, rows);
	}

	public int getFlowListByUser_idCount(Integer user_id) {
		return flowDao.getFlowListByUser_idCount(user_id);
	}

	public boolean addContractFlow(Integer user_id, double contract_money) {
		return flowDao.addContractFlow(user_id, contract_money) > 0;
	}

	public List<String> getFlowTypes() {
		return flowDao.getFlowTypes();
	}

}
