package com.jobskills.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobskills.entity.UserPojo;

@Repository
public interface UserRepository extends JpaRepository<UserPojo, String>{
   UserPojo findByUsername(String username);
} 
