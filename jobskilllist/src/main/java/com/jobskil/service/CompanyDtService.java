package com.jobskil.service;

import java.util.List;

import com.jobskil.domain.CompanyDetails;

public interface CompanyDtService {
	public boolean saveDetails(CompanyDetails company);
	public List<CompanyDetails> getAllCompantDt();
	public List<CompanyDetails> serchCompantDt(String sql);

}
