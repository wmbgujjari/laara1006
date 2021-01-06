package com.harleeninfo.venkatsai.jobs.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harleeninfo.venkatsai.jobs.repository.UserRepository;
import com.harleeninfo.venkatsai.jobs.entity.RecProfile;
import com.harleeninfo.venkatsai.jobs.entity.User;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class AdmindashboardController {

	RestTemplate restTemplate;
    UserRepository user;
	
    @RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
   public String registrationsave(RecProfile adminForm, BindingResult bindingResult, Model model)
        throws JsonMappingException, JsonProcessingException
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<RecProfile>> respones = restTemplate.exchange("http://localhost:8890/getCompanyDetails", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<RecProfile>>(){});
  
        HttpStatus httpStatus = respones.getStatusCode();
		System.out.println("Status Code: " + httpStatus);

		List<RecProfile> products = respones.getBody();        
        
        model.addAttribute("products", products);
        System.out.println("response"+respones);
        if(bindingResult.hasErrors())
            return "adminDashboard";
        else
            return "adminDashboard";
    }
    
    @RequestMapping(value = "/adminDashboardupdate/{id}", method = RequestMethod.GET)    
    public String rec(@PathVariable("id") String id)
    {
    	System.out.println("syste"+id);
    	HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        //HttpEntity entity = new HttpEntity(adminForm, headers);
       
       ResponseEntity<String> respones = restTemplate.exchange("http://localhost:8890/enableRec?id="+id, HttpMethod.GET,entity,String.class);
        System.out.println(respones);
     /*   if(bindingResult.hasErrors())
            return "adminDashboard";
        else
            return "adminDashboard";*/
    	return "adminDashboardupdate";
    	
    }
}


