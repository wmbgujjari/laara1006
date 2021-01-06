package com.jobskil.dao;

import java.util.List;

import com.jobskil.domain.RecProfileJob;

public interface JobPostingDao {
  public boolean saveJobPosting(RecProfileJob recJob);
  public List<RecProfileJob> getDataJobPostin(String id);
}
