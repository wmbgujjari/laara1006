package com.jobskil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="seeker_details")
public class ApplyJob  implements Serializable{
		
	@Id
   	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 long id;
	  @Column(name="seekermobile")
      String seekermobile;
	  @Column(name="seekermail")
      String seekermail;
	  @Column(name="seekercv")
      String seekercv;
	  @Column(name="job_id")
      int job_id;
	  @Column(name="rec_id")
	  int rec_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSeekermobile() {
		return seekermobile;
	}
	public void setSeekermobile(String seekermobile) {
		this.seekermobile = seekermobile;
	}
	public String getSeekermail() {
		return seekermail;
	}
	public void setSeekermail(String seekermail) {
		this.seekermail = seekermail;
	}
	public String getSeekercv() {
		return seekercv;
	}
	public void setSeekercv(String seekercv) {
		this.seekercv = seekercv;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getRec_id() {
		return rec_id;
	}
	public void setRec_id(int rec_id) {
		this.rec_id = rec_id;
	}
	
     
}
