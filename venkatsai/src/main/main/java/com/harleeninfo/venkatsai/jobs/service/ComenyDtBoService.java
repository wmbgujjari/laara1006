package com.harleeninfo.venkatsai.jobs.service;

import java.util.List;

import com.harleeninfo.venkatsai.jobs.entity.RecProfile;
import com.harleeninfo.venkatsai.jobs.entity.RecProfileJob;
import com.harleeninfo.venkatsai.vo.CommanResponsVo;
import com.harleeninfo.venkatsai.vo.RecProfileJobVo;

public interface ComenyDtBoService {
	List<RecProfile> findByUser(String userName);
	public String isEnable(String id);
	public CommanResponsVo getJpobPostingByid(String id);
	
}
