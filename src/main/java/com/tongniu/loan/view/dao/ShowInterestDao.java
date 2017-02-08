package com.tongniu.loan.view.dao;

import java.util.List;

import com.tongniu.loan.view.domain.ShowInterest;

public interface ShowInterestDao {
	List<ShowInterest> getAllShowInterestList(int start, int row);

	int getAllShowInterestListCount();

	List<ShowInterest> searchShowInterest(int start, int row, String value);

	int searchShowInterestCount(String value);
}
