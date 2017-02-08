package com.tongniu.loan.business.dao;

import java.util.List;

import com.tongniu.loan.business.domain.Parameter;

public interface ParameterDao {
	List<Parameter> getAllNeedPara(Integer type_id);
}
