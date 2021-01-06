package com.jobskil.service;

import java.util.List;

import com.jobskil.domain.RecProfile;

public interface JobListService {
	public boolean saveRecProfile(RecProfile rec);
	public List<RecProfile> getCompanyDetails();
	public int updateRecProfile(String enableStatus,int id);
}
