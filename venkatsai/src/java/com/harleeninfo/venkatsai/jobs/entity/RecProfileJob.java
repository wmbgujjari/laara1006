package com.harleeninfo.venkatsai.jobs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class RecProfileJob implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	@Column(name="companyname")
	String companyname;
	@Column(name="companyemail")
	String companyemail ;
	@Column(name="mobileno")
	String mobileno ;
	@Column(name="jobtype")
	String jobtype ;
	@Column(name="descr")
	String descr;
	@Column(name="status ")
	String status ;
	@Column(name="image_name")
	String imageNmae;
	
	public String getImageNmae() {
		return imageNmae;
	}
	public void setImageNmae(String imageNmae) {
		this.imageNmae = imageNmae;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanyemail() {
		return companyemail;
	}
	public void setCompanyemail(String companyemail) {
		this.companyemail = companyemail;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
