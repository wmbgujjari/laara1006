package com.jobskil.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobskil.dao.JobListDao;
import com.jobskil.dao.UpdateRecDao;
import com.jobskil.domain.RecProfile;
import com.jobskil.domain.RecProfileJob;
import com.jobskil.service.JobPostingService;
import com.jobskil.vo.CommanResponsVo;
import com.jobskil.vo.JobListVo;

@RestController
public class JobListController {
	@Autowired
	JobListDao jobList;
	
	
	/*@Autowired
	UpdateRecDao updateRecDao;*/
	
	@RequestMapping("/")
    public List<Object> getJobLits() 
    {
		jobList.getData();
		List<Object> list=new ArrayList<Object>();
		JobListVo job1=new JobListVo();
		job1.setJobDescr("job1");
		job1.setUserName("test");
		 
		list.add(job1);
		
		return list;
    }
	
	@RequestMapping("/getCompanyDetails")
    public List<RecProfile> getCompanyDetails() 
    {
		jobList.getData();
		List<RecProfile> list=jobList.getCompanyDetails();
		
		//JobListVo job1=new JobListVo();
		//job1.setJobDescr("job1");
		//job1.setUserName("test");
		
		//list.add(job1);
		
		return list;
    }	
	@GetMapping("/enableRec")
	public CommanResponsVo  updateRecProfile(@RequestParam  int id) {
		System.out.println("updating"+id);
		
		

		
		
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		try {
			boolean a= jobList.updateRecProfile(id);
		if(a) {
			comm.setStatus("true");
			comm.setError("Sucess");
		}else{
			comm.setStatus("flase");
			comm.setError("Failure..");
		}
		}catch (Exception e) {
			comm.setStatus("flase");	
			comm.setError("Somthing weant wrog try again......");
			// TODO: handle exception
		}
		//comm.setRespons(rec);
		return comm;

		
	}
	
	@PostMapping("/jobslist")
	public CommanResponsVo getJobList(@RequestBody RecProfile rec) {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		try {
		if(jobList.saveRecProfile(rec)) {
			comm.setStatus("true");
			comm.setError("Sucess");
		}else{
			comm.setStatus("flase");
			comm.setError("Failure..");
		}
		}catch (Exception e) {
			comm.setStatus("flase");	
			comm.setError("Somthing weant wrog try again......");
			// TODO: handle exception
		}
		//comm.setRespons(rec);
		return comm;
	}
		
	
	
}
