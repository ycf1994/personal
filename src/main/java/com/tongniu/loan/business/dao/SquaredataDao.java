package com.tongniu.loan.business.dao;

import java.util.List;

import com.tongniu.loan.business.domain.Squaredata;

public interface SquaredataDao {
	/**
	 * 插入交易信息
	 * */
	int addSquaredata(Squaredata squaredata);
	
	/**
	 * 根据资金ID查询全部的交易信息
	 * */
	List<Squaredata> getSquaredataListByFund_id(Integer fund_id);
}
