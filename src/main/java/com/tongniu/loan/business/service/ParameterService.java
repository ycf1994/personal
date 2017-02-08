package com.tongniu.loan.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.business.dao.ParameterDao;
import com.tongniu.loan.business.domain.Parameter;

@Service(value="parameterService")
public class ParameterService {
	@Resource
	private ParameterDao parameterDao;
	
	public List<Parameter> getAllNeedPara(Integer type_id){
		return parameterDao.getAllNeedPara(type_id);
	}
}
