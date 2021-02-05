package com.harleeninfo.venkatsai.jobs.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harleeninfo.venkatsai.jobs.entity.OtpUser;
import com.harleeninfo.venkatsai.jobs.entity.User;
import com.harleeninfo.venkatsai.jobs.repository.RoleRepository;
import com.harleeninfo.venkatsai.jobs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void saveotp(OtpUser user) {
		
		userRepository.save(user);
	}
}
