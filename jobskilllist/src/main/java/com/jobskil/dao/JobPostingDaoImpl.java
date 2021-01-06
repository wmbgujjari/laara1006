package com.jobskil.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobskil.domain.CompanyDetails;
import com.jobskil.domain.RecProfileJob;
@Repository
public class JobPostingDaoImpl implements JobPostingDao{
	@Autowired
	private SessionFactory sessionFactory;
 

	
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public boolean saveJobPosting(RecProfileJob recJob) {
		// TODO Auto-generated method stub
		boolean index=false;
		try {
			this.sessionFactory.getCurrentSession().save(recJob);
			index=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return index;
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<RecProfileJob> getDataJobPostin(String id) {
		// TODO Auto-generated method stub
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(RecProfileJob.class);
		List<RecProfileJob> list = criteria.list();
		return list;
	}

}
