package com.jobskil.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobskil.domain.ApplyJob;
@Repository
public class ApplyJobDaoImpl implements ApplyJobDao{
	@Autowired
	private SessionFactory sessionFactory;
 

	
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public boolean applyJob(ApplyJob apply) {
		// TODO Auto-generated method stub
		boolean index=false;
		try {
			this.sessionFactory.getCurrentSession().save(apply);
			index=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return index;
	}

}
