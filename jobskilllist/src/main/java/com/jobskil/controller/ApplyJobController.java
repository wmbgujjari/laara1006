package com.jobskil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobskil.domain.ApplyJob;
import com.jobskil.domain.RecProfileJob;
import com.jobskil.service.ApplyJobService;
import com.jobskil.vo.CommanResponsVo;
@RestController
public class ApplyJobController {
	@Autowired
	ApplyJobService applyJob;
	@PostMapping("/applyjob")
	public CommanResponsVo applyJob(@RequestBody ApplyJob apply) {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		try {
		if(applyJob.applyJob(apply)) {
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
}
