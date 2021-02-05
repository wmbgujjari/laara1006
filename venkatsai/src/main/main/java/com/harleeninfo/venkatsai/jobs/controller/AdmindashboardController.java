package com.harleeninfo.venkatsai.jobs.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harleeninfo.venkatsai.jobs.repository.UserRepository;
import com.harleeninfo.venkatsai.jobs.service.ComenyDtBoService;
import com.harleeninfo.venkatsai.vo.CommanResponsVo;
import com.harleeninfo.venkatsai.jobs.entity.RecProfile;
import com.harleeninfo.venkatsai.jobs.entity.User;

import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    ComenyDtBoService commDtService;
	
    @RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
   public String registrationsave(RecProfile adminForm, BindingResult bindingResult, Model model)
        throws JsonMappingException, JsonProcessingException
    {


		List<RecProfile> products = commDtService.findByUser("");        
        
        model.addAttribute("products", products);
      //  System.out.println("response"+respones);
        if(bindingResult.hasErrors())
            return "adminDashboard";
        else
            return "adminDashboard";
    }
    
    @RequestMapping(value = "/adminDashboardupdate/{id}", method = RequestMethod.GET)    
    public String rec(@PathVariable("id") String id,Model model) throws URISyntaxException
    {
    	
        String pageName = null;
    	String index=commDtService.isEnable(id);
        
         if(index.equals("true")) {

     		List<RecProfile> products = commDtService.findByUser("");        
             
            
             if(products.size()>0) {
            	 model.addAttribute("products", products); 
            	 pageName ="adminDashboard";
             }else {
            	 model.addAttribute("title", "Admin DashBoard"); 
            	 model.addAttribute("erroe", "NO DATA FOUND"); 
            	 pageName="dataError";
             }
        	 
         }else {
        	 model.addAttribute("title", "Admin DashBoard"); 
        	 model.addAttribute("erroe", "NO DATA FOUND"); 
        	 pageName="dataError"; 
         }
         
         
    	
    	
    	
     /*   if(bindingResult.hasErrors())
            return "adminDashboard";
        else
            return "adminDashboard";*/
    	return pageName;
    	
    }
}


