package com.jobskil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobskil.dao.ApplyJobDao;
import com.jobskil.domain.ApplyJob;
@Service
public class ApplyJobServiceImpl implements ApplyJobService {
	@Autowired
	ApplyJobDao applyDao;
	@Override
	public boolean applyJob(ApplyJob apply) {
		// TODO Auto-generated method stub
		return applyDao.applyJob(apply);
	}

}
