package com.jobskil.dao;

import java.util.List;

import com.jobskil.domain.CompanyDetails;

public interface CompanyDtDao {
public boolean saveDetails(CompanyDetails company);
public List<CompanyDetails> getAllCompantDt();
public List<CompanyDetails> serchCompantDt(String sql);
}
