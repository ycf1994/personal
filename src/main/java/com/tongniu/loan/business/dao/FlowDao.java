package com.tongniu.loan.business.dao;

import java.util.List;

import com.tongniu.loan.business.domain.Flow;

public interface FlowDao {

	/**
	 * 添加资金流水记录
	 */
	int addFlow(Flow flow);

	/**
	 * 根据用户ID查询资金流水记录
	 */
	List<Flow> findFlowsByUser_id(Integer user_id);

	/**
	 * 根据用户ID查询资金提现记录
	 */
	List<Flow> findCashFlowsByUser_id(Integer user_id);

	/**
	 * 根据用户ID查询资金入账记录
	 */
	List<Flow> findRecordFlowsByUser_id(Integer user_id);

	List<Flow> getFlowListByUser_id(Integer user_id, int start, int rows);

	int getFlowListByUser_idCount(Integer user_id);

	int addContractFlow(Integer user_id, double contract_money);

	List<String> getFlowTypes();
}
