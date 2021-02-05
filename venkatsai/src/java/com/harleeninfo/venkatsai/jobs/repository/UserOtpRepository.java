package com.harleeninfo.venkatsai.jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harleeninfo.venkatsai.jobs.entity.OtpUser;

public interface UserOtpRepository extends JpaRepository<OtpUser, Long> {
	
}
