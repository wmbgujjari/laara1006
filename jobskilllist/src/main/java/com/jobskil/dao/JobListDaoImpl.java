package com.jobskil.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.hibernate.Transaction;

import com.jobskil.domain.RecProfile;

@Repository

public class JobListDaoImpl implements JobListDao{
	@Autowired
	private SessionFactory sessionFactory;
 

	 private Transaction transaction = null;
    /*@PersistenceContext
    private EntityManager manager;**/
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public void getData() {
		 Query session = this.sessionFactory.getCurrentSession().createSQLQuery("select * from user");
		// TODO Auto-generated method stub
		 List j = session.list();
		 System.out.println(j);
		
		
	}
	
	@Override
	public boolean saveRecProfile(RecProfile rec) {
		boolean index=false;
		try {
			rec.setStatus("ACTIVE");
			this.sessionFactory.getCurrentSession().save(rec);
			index=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return index;
	}
	@Override
	public List<RecProfile> getCompanyDetails() {
		// TODO Auto-generated method stub
		List<RecProfile> recProfile = this.sessionFactory.getCurrentSession().createNativeQuery(
			    "SELECT * FROM rec_profile where status='ACTIVE'", RecProfile.class )
			.getResultList();
			 return recProfile;
	}

	
	public boolean  updateRecProfile(int id) {
    	boolean index=false;
		try {
		
    	int i=0;
  //  transaction = ((SharedSessionContract) sessionFactory).beginTransaction();
    	
    	Session session=this.sessionFactory.openSession();
    	transaction=session.beginTransaction();
    	//
    	
    	 NativeQuery qury = session.createNativeQuery("UPDATE rec_profile set status = 'INACTIVE' where   id=:id");
    	 qury.setInteger("id", id);
    	 qury.executeUpdate();
 		transaction.commit();
//    session.getTransaction().begin();
//	status=	session.createSQLQuery("UPDATE rec_profile set status = 'INACTIVE' where   id=:id");
//	status.setInteger("id", id);
//	status.executeUpdate();
//	session.beginTransaction().commit();
	index=true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
    
	return index;	
    	
	}
	
}
