package com.jobskil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobskil.dao.CommanDao;
@Service
public class CommanServiceImpl implements CommanService {
	@Autowired
	CommanDao commanDao;
	@Override
	public boolean commanUpdate(String sql) {
		// TODO Auto-generated method stub
		return commanDao.commanUpdate(sql);
	}

}
