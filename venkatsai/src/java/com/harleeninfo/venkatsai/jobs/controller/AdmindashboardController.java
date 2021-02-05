package com.harleeninfo.venkatsai.jobs.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harleeninfo.venkatsai.jobs.repository.UserRepository;
import com.harleeninfo.venkatsai.jobs.service.ComenyDtBoService;
import com.harleeninfo.venkatsai.jobs.service.EmailService;
import com.harleeninfo.venkatsai.jobs.service.OTPService;
import com.harleeninfo.venkatsai.jobs.service.UserService;
import com.harleeninfo.venkatsai.jobs.vo.CommanResponsVo;
import com.harleeninfo.venkatsai.jobs.vo.RecProfileJobVo;
import com.harleeninfo.venkatsai.jobs.entity.RecProfile;
import com.harleeninfo.venkatsai.jobs.entity.User;

import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import java.util.Arrays;
import java.util.HashMap;

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
    User User=null;
    @Autowired
    private UserService userService;
    @Autowired
    ComenyDtBoService commDtService;
    @Autowired
    public EmailService emailService;
    @Autowired
    public OTPService otpService;
    
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
        
    	CommanResponsVo com = commDtService.getJpobPostingByid("1");
   	 List<RecProfileJobVo> profile=(List<RecProfileJobVo>) com.getRespons();
   	 model.addAttribute("profile", profile);
   	 
   	 
        System.out.println("response"+respones);
        if(bindingResult.hasErrors())
            return "adminDashboard";
        else
            return "adminDashboard";
    }
    
    @RequestMapping(value = "/adminDashboardupdate/{id}/{Email}/{CName}", method = RequestMethod.GET)    
    public String rec(@PathVariable("id") String id,@PathVariable("Email") String Email,@PathVariable("CName") String CName,Model model) throws URISyntaxException, MessagingException
    {
    	
        String pageName = null;
    	String index=commDtService.isEnable(id);
  	
        
         if(index.equals("true")) {

        	int iend = Email.indexOf("@"); 
        	String password="";
        	if (iend != -1) 
        	{
        		password= Email.substring(0 , iend); //this will give abc
        	}
        	
        	int otp = otpService.generateOTP(Email);
        	EmailTemplate template = new EmailTemplate("SendPassword.html");
        	Map<String,String> replacements = new HashMap<String,String>();
        	replacements.put("user", CName);
        	replacements.put("username", Email);
        	replacements.put("password", password+"@"+String.valueOf(otp));
        	String message = template.getTemplate(replacements);
        	emailService.sendOtpMessage(Email, "Password Notification", message);
        	
        	
         	User user=new User();
         	user.setEmail(Email);
        	user.setUsername(Email);
        	user.setFullname(CName);
        	user.setPassword(password+"@"+String.valueOf(otp));
        	userService.save(user);
        	
        	
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
         
         return pageName;
    	
    }
}


