package com.jobskil.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@EnableTransactionManagement
public interface  UpdateRecDao {

	public int updateRecProfile(String enableStatus,int id);
}
