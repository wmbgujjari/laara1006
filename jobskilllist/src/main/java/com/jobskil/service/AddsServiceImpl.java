package com.jobskil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobskil.dao.AddsDao;
import com.jobskil.domain.AddsMo;
@Service
public class AddsServiceImpl  implements AddsService{
	@Autowired
	AddsDao addsDao;
	@Override
	public List<AddsMo> getAllAdds() {
		// TODO Auto-generated method stub
		return addsDao.getAllAdds();
	}

}
