package com.harleeninfo.venkatsai.jobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harleeninfo.venkatsai.jobs.entity.Comments;
import com.harleeninfo.venkatsai.jobs.repository.CommentsRepository;

@Service
public class CommentsServiceImpl implements CommentsService {
	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public void save(Comments comments) {
		commentsRepository.save(comments);
		
	}
}
