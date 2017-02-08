package com.tongniu.loan.business.dao;

import java.util.List;

import com.tongniu.loan.business.domain.Hqinfo;

public interface HqinfoDao {
	/**
	 * 插入每日行情
	 * */
	int add(Hqinfo hqinfo);
	
	int find(String stock_code);
	
	int update(Hqinfo hqinfo);
	
	List<Hqinfo> findHqinfoList_Rows(String codeOrName,int hq_date,int start,int rows);
	
	int findHqinfoList_Total(String codeOrName,int hq_date);
	
	
}
