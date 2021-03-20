package com.jobskil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobskil.domain.AddsMo;
import com.jobskil.domain.RecProfileJob;
import com.jobskil.service.AddsService;
import com.jobskil.vo.CommanResponsVo;
@RestController
public class AddsController {
	@Autowired
	AddsService addsService;
	@GetMapping("/getalladds")
	public CommanResponsVo getAllAdds() {
		CommanResponsVo comm=new CommanResponsVo();
		System.out.println("post man");
		 List<AddsMo> list = addsService.getAllAdds();
		
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
