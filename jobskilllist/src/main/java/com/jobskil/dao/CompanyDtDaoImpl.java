package com.jobskil.dao;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobskil.domain.CompanyDetails;
import com.jobskil.domain.RecProfile;
@Repository
public class CompanyDtDaoImpl implements CompanyDtDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	
	public boolean saveDetails(CompanyDetails company) {
		// TODO Auto-generated method stub
		boolean index=false;
		try {
			//company.setCompanyId(7);
			this.sessionFactory.getCurrentSession().save(company);
			index=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return index;
	}
	@Override
	public List<CompanyDetails> getAllCompantDt() {
		// TODO Auto-generated method stub
		List<CompanyDetails> list;
		 list = this.sessionFactory.getCurrentSession().createNativeQuery( "SELECT * FROM companydetails", CompanyDetails.class )
			.getResultList();
		
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CompanyDetails.class);
		 list = criteria.list();
		return list;
	}
	@Override
	public List<CompanyDetails> serchCompantDt(String sql) {
		// TODO Auto-generated method stub
		List<CompanyDetails> list;
		 list = this.sessionFactory.getCurrentSession().createNativeQuery( "SELECT * FROM companydetails where "+sql, CompanyDetails.class )
			.getResultList();
		
	
		return list;
	}

}
