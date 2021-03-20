package com.jobskil.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobskil.domain.AddsMo;
import com.jobskil.domain.RecProfileJob;
@Repository
public class AddsDaoImpl implements AddsDao{
	@Autowired
	private SessionFactory sessionFactory;
 

	
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public List<AddsMo> getAllAdds() {
		// TODO Auto-generated method stub
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AddsMo.class);
		List<AddsMo> list = criteria.list();
		return list;
	}

}
