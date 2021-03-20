package com.harleeninfo.venkatsai.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class AddsVo  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	   long addsId;
   
       String location;
    
      String youtubeDescr;
    
      String imageName;
      
      String imageDesc;
   
      String satus;
	public long getAddsId() {
		return addsId;
	}
	public void setAddsId(long addsId) {
		this.addsId = addsId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getYoutubeDescr() {
		return youtubeDescr;
	}
	public void setYoutubeDescr(String youtubeDescr) {
		this.youtubeDescr = youtubeDescr;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageDesc() {
		return imageDesc;
	}
	public void setImageDesc(String imageDesc) {
		this.imageDesc = imageDesc;
	}
	public String getSatus() {
		return satus;
	}
	public void setSatus(String satus) {
		this.satus = satus;
	}
     
      
      
      					
}
