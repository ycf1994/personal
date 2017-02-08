package com.tongniu.loan.role.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tongniu.loan.role.dao.CustDao;
import com.tongniu.loan.role.domain.Cust;

@Service(value = "custService")
public class CustService {
	@Resource
	private CustDao custDao;

	/**
	 * 根据ID查询借款客户信息
	 */
	public Cust getCustById(Integer id) {
		return custDao.getCustById(id);
	}

	/**
	 * 查询全部借款用户信息
	 */
	public List<Cust> getCustList(int page, int rows) {
		return custDao.getCustList((page - 1) * rows, rows);
	}

	public int getCustLsitCount() {
		return custDao.getCustListCount();
	}

	public List<Cust> searchCust(int page, int rows, String realname) {
		return custDao.searchCust((page - 1) * rows, rows, realname);

	}

	public int searchCustCount(String realname) {
		return custDao.searchCustCount(realname);

	}
	
	public Integer getIdByRealnameAndIdno(String realname,String idno){
		return custDao.getIdByRealnameAndIdno(realname, idno);
	}
	
	public boolean addCust(Cust cust){
		return custDao.addCust(cust)>0;
	}
	
	public List<Cust> getAllCustList(){
		return custDao.getAllCustList();
	}
	
}
