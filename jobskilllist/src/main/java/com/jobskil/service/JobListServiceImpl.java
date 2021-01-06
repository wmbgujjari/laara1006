package com.jobskil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobskil.dao.JobListDao;
import com.jobskil.dao.UpdateRecDao;
import com.jobskil.domain.RecProfile;
@Service
public class JobListServiceImpl implements JobListService {
	@Autowired
	JobListDao jobList;
	
	@Autowired
	UpdateRecDao updateRecDao;
	
	@Override
	public boolean saveRecProfile(RecProfile rec) {
		// TODO Auto-generated method stub
		return jobList.saveRecProfile(rec);
	}
	@Override
	public List<RecProfile> getCompanyDetails() {
		// TODO Auto-generated method stub
		return jobList.getCompanyDetails();
	}
	@Override
	public int updateRecProfile(String enableStatus,int id) {
		return updateRecDao.updateRecProfile(enableStatus, id);
	} 
}
