package com.harleeninfo.venkatsai.jobs.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harleeninfo.venkatsai.jobs.entity.RecProfile;
import com.harleeninfo.venkatsai.jobs.entity.RecProfileJob;
import com.harleeninfo.venkatsai.jobs.vo.CommanResponsVo;
import com.harleeninfo.venkatsai.jobs.vo.RecProfileJobVo;
@Service
public class ComenyDtBoServiceImple implements ComenyDtBoService{
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<RecProfile> findByUser(String userName) {
		
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        restTemplate = new RestTemplate();
	        ResponseEntity<List<RecProfile>> respones = restTemplate.exchange("http://localhost:8890/getCompanyDetails", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<RecProfile>>(){});
	  
	        HttpStatus httpStatus = respones.getStatusCode();
			System.out.println("Status Code: " + httpStatus);

		//	List<RecProfile> products = respones.getBody();   
		// TODO Auto-generated method stub
		return respones.getBody();
	}
	@Override
	public String isEnable(String id) {
		 HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         
         restTemplate = new RestTemplate();
         ResponseEntity<String> respones = restTemplate.exchange("http://localhost:8890/enableRec?id="+id, HttpMethod.GET, null,
 				new ParameterizedTypeReference<String>(){});
   
         HttpStatus httpStatus = respones.getStatusCode();
 		System.out.println("Status Code: " + httpStatus);

 		String products = respones.getBody();        
         JSONObject obj=new JSONObject(products);
		// TODO Auto-generated method stub
		return obj.getString("status");
	}
	@Override
	public CommanResponsVo getJpobPostingByid(String id) {
		// TODO Auto-generated method stub
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        restTemplate = new RestTemplate();
	        ResponseEntity<CommanResponsVo> respones = restTemplate.exchange("http://localhost:8890/postingById?id='1'", HttpMethod.GET, null,
					new ParameterizedTypeReference<CommanResponsVo>(){});
	  
	        HttpStatus httpStatus = respones.getStatusCode();
			System.out.println("Status Code: " + httpStatus);
           // JSONObject json=new JSONObject(respones.getBody());
		//	List<RecProfile> products = respones.getBody();   
		// TODO Auto-generated method stub
		return respones.getBody();
	}

}
