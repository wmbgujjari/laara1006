package com.jobskil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobskil.dao.CompanyDtDao;
import com.jobskil.domain.CompanyDetails;
@Service
public class CompanyDtServiceImpl implements CompanyDtService{
	@Autowired
	CompanyDtDao companyDao;
	@Override
	public boolean saveDetails(CompanyDetails company) {
		// TODO Auto-generated method stub
		return companyDao.saveDetails(company);
	}
	@Override
	public List<CompanyDetails> getAllCompantDt() {
		// TODO Auto-generated method stub
		return companyDao.getAllCompantDt();
	}
	@Override
	public List<CompanyDetails> serchCompantDt(String sql) {
		// TODO Auto-generated method stub
		return companyDao.serchCompantDt(sql);
	}

}
