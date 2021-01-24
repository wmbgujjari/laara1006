package com.jobskil.dao;

import java.util.List;

import com.jobskil.domain.RecProfile;

public interface JobListDao {
public List<RecProfile> getCompanyDetails();
public void getData();
public boolean saveRecProfile(RecProfile rec);
public boolean updateRecProfile(int id);
}
