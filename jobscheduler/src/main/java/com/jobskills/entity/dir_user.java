package com.jobskills.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dir_user")
public class dir_user {

    // "customer_seq" is Oracle sequence name.
	@Id
	@Column(name="ID")
	String id;
	
    @Column(name="USERNAME")
    String username;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    
    //getters and setters, contructors
}
