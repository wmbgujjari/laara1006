package com.jobskills.service;

import org.springframework.data.repository.query.Param;

import com.jobskills.entity.dir_user;



public interface DirService {
	 dir_user findByusername(@Param("username") String username);
}
