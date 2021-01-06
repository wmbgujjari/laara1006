package com.jobskil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobskil.dao.JobPostingDao;
import com.jobskil.domain.RecProfileJob;
@Service
public class JobPostingServiceImpl implements JobPostingService{
	@Autowired
	JobPostingDao jobPosting;
	@Override
	public boolean saveJobPosting(RecProfileJob recJob) {
		// TODO Auto-generated method stub
		return jobPosting.saveJobPosting(recJob);
	}
	@Override
	public List<RecProfileJob> getDataJobPostin(String id) {
		// TODO Auto-generated method stub
		return jobPosting.getDataJobPostin(id);
	}

}
