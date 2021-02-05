package com.harleeninfo.venkatsai.jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harleeninfo.venkatsai.jobs.entity.Comments;


public interface CommentsRepository extends JpaRepository<Comments, Long> {
	
}
