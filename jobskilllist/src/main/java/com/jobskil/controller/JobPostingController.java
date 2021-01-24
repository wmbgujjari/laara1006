package com.jobskil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobskil.domain.CompanyDetails;
import com.jobskil.domain.RecProfileJob;
import com.jobskil.service.JobPostingService;
import com.jobskil.vo.CommanResponsVo;
import com.jobskil.vo.SerchVo;
@RestController
public class JobPostingController {
	@Autowired
	JobPostingService jobPosting;
	
	@PostMapping("/jobsPosting")
	public CommanResponsVo jobPosting(@RequestBody RecProfileJob rec) {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		try {
		if(jobPosting.saveJobPosting(rec)) {
			comm.setStatus("true");
			comm.setError("Success");
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
	
	@GetMapping("/postingById")
	public CommanResponsVo postingByIdbyi(@RequestParam("id") String id) {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		List<RecProfileJob> list=jobPosting.getDataJobPostin(id);
		
		try {
		if(list.size()>0) {
			comm.setStatus("true");
			comm.setError("Success");
			comm.setRespons(list);
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
	
	@GetMapping("/postingAll")
	public CommanResponsVo postingAll(@PathVariable("id") String id) {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		List<RecProfileJob> list=jobPosting.getDataJobPostin(id);
		
		try {
		if(list.size()>0) {
			comm.setStatus("true");
			comm.setError("Success");
			comm.setRespons(list);
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
