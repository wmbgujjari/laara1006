package com.jobskills.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobskills.entity.dir_user;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface dir_userRepo extends JpaRepository<dir_user, String> {

	@Query(value="select * from dir_user where id = ?1",nativeQuery = true)
    List <dir_user> findByusername(String username);
	
}