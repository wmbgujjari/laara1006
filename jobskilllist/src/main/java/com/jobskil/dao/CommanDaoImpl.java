package com.jobskil.dao;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CommanDaoImpl implements CommanDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	//
	@Override
	public boolean commanUpdate(String sql) {
		Session session = null;
		boolean index=false;
		try {
			session = this.sessionFactory.getCurrentSession();
		//session.getTransaction().begin();
		 NativeQuery qury = session.createSQLQuery(sql);
		qury.executeUpdate();
		
		//session.getTransaction().commit();
		index=true;
		}catch (Exception e) {
			e.printStackTrace();
			//session.getTransaction().rollback();;
			// TODO: handle exception
		}
		finally {
			//session.close();
		}
		return index;
		
		
		
		// TODO Auto-generated method stub
		
	}

}
