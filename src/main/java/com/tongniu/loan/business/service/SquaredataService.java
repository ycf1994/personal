package com.tongniu.loan.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.business.dao.SquaredataDao;
import com.tongniu.loan.business.domain.Squaredata;

@Service(value = "squaredataService")
public class SquaredataService {
	@Resource
	private SquaredataDao squaredataDao;

	/**
	 * 插入交易信息
	 */
	public boolean addSquaredata(Squaredata squaredata) {
		return squaredataDao.addSquaredata(squaredata) > 0;
	}

	/**
	 * 根据资金ID查询全部的交易信息
	 */
	public List<Squaredata> getSquaredataListByFund_id(Integer fund_id) {
		return squaredataDao.getSquaredataListByFund_id(fund_id);
	}
}
