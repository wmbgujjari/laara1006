package com.jobskil.dao;


	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;
	
	 
	@Repository
	@Transactional
	public class UpdateRecDaoImpl implements UpdateRecDao 
	{
	 
	    @PersistenceContext
	    private EntityManager manager;
	     
	    @Override
	    public int  updateRecProfile(String enableStatus,int id) {
			
	    	int status=	manager.createNativeQuery(
	    			    "UPDATE rec_profile u set country ='"+enableStatus+"' where u.id ="+id+"").executeUpdate();
	    			return status;
	    			
	    	}
	
}
