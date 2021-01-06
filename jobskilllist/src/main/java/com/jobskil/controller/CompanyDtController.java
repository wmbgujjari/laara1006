package com.jobskil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobskil.domain.CompanyDetails;
import com.jobskil.domain.RecProfile;
import com.jobskil.domain.RecProfileJob;
import com.jobskil.service.CommanService;
import com.jobskil.service.CompanyDtService;
import com.jobskil.vo.CommanResponsVo;
import com.jobskil.vo.SerchVo;

@RestController
public class CompanyDtController {
	@Autowired
	CompanyDtService companyDtService;
	
	
	@PostMapping("/saveCompany")
	public CommanResponsVo saveCompany(@RequestBody CompanyDetails company) {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		try {
		if(companyDtService.saveDetails(company)) {
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
	
	@RequestMapping("/getCompanyDt")
    public CommanResponsVo getCompanyDetails() 
    {
		
		List<CompanyDetails> list=companyDtService.getAllCompantDt();
		
		CommanResponsVo comm=new CommanResponsVo();
		
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
	
	@PostMapping("/serchCompany")
	public CommanResponsVo serchCompany(@RequestBody SerchVo company) {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		List<CompanyDetails> list=companyDtService.serchCompantDt(company.getSql());
		
		try {
		if(list.size()>0) {
			comm.setStatus("true");
			comm.setError("Sucess");
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
