package com.jobskil.service;

import java.util.List;

import com.jobskil.domain.RecProfileJob;

public interface JobPostingService {
	public boolean saveJobPosting(RecProfileJob recJob);
	public List<RecProfileJob> getDataJobPostin(String id);
}
