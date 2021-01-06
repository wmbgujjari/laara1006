package com.jobskil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobskil.service.CommanService;
import com.jobskil.vo.CommanResponsVo;
import com.jobskil.vo.SerchVo;

@RestController
public class CommanDMLController {
	@Autowired
	CommanService commanService;
	@PostMapping("/commanUpdateOrDelect")
	public CommanResponsVo commanUpdate(@RequestBody SerchVo company) {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		try {
		if(commanService.commanUpdate(company.getSql())) {
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
