package com.tongniu.loan.view.dao;

import java.util.List;

import com.tongniu.loan.view.domain.ShowFlow;

public interface ShowFlowDao {
	List<ShowFlow> getAllShowFlowList(int start, int row);

	int getAllShowFlowListCount();

	List<ShowFlow> searchShowFlow(String value, int flag, int start, int row);

	int searchShowFlowCount(String value, int flag);

}
