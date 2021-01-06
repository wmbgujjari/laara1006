package com.jobskil.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="companydetails")
public class CompanyDetails implements Serializable{
							

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	@Column(name="areaId")
	int areaId;
	@Column(name="location")
	String location;
	@Column(name="companyName")
	String companyName;
	@Column(name="categoryId")
	String categoryId;
	@Column(name="description")
	String description;
	@Column(name="title")
	String title;
	@Column(name="createDate")
	Date createDate;
	@Column(name="updateDate")
	Date updateDate;
	@Column(name="recordStatus")
	String recordStatus;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	
}
