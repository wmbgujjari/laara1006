package com.harleeninfo.venkatsai.vo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ApplyJobVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String postId;
	String emailId;
	String mobileNumber;
	MultipartFile cv;
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public MultipartFile getCv() {
		return cv;
	}
	public void setCv(MultipartFile cv) {
		this.cv = cv;
	}
	
	

}
