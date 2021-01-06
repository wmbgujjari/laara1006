package com.jobskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobskills.entity.dir_user;
import com.jobskills.repo.dir_userRepo;


@Service
public class DirServiceImpl implements DirService {
	@Autowired
	dir_userRepo repo;

	@Override
	public dir_user findByusername(String username) {
		// TODO Auto-generated method stub
		return (dir_user) repo.findByusername(username);
	}

}
