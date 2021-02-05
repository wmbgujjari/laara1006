package com.harleeninfo.venkatsai.jobs.controller;


import com.harleeninfo.venkatsai.jobs.entity.RecProfile;
import com.harleeninfo.venkatsai.jobs.entity.User;

import java.io.PrintStream;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@Controller
public class companyRegisterController
{

	RestTemplate restTemplate;

    @RequestMapping(value = "/companyRegister", method = RequestMethod.GET)
    public String registration(Model model)
    {
        model.addAttribute("companyForm", new RecProfile());
        return "companyRegister";
    }
     
   
    
    @RequestMapping(value = "/companyRegister", method = RequestMethod.POST)
    public String Compamysave(@ModelAttribute("companyForm") RecProfile companyForm, BindingResult bindingResult, Model model)
    {
      
    	//System.out.println((new StringBuilder()).append(id).toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity entity = new HttpEntity(companyForm, headers);
        RestTemplate restTemplate = new RestTemplate();
        //System.out.println((new StringBuilder()).append(id).toString());
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8890/jobslist", HttpMethod.POST, entity, String.class);
        System.out.println(response);
        if(bindingResult.hasErrors())
            return "companyRegister";
        else
            return "companyRegister";
    	
           
    }

    
}

