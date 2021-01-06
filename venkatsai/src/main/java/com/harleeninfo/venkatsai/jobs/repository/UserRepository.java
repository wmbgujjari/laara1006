package com.harleeninfo.venkatsai.jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harleeninfo.venkatsai.jobs.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
