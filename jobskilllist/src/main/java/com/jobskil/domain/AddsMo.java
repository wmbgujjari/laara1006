package com.jobskil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adds_trans")
public class AddsMo  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
	
	  @Column(name="id")
	
	   long addsId;
      @Column(name="youtubeurl")
       String location;
      @Column(name="youtubedescr")
      String youtubeDescr;
      @Column(name="imagename")
      String imageName;
      @Column(name="imagedescr")
      String imageDesc;
      @Column(name="status")
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
