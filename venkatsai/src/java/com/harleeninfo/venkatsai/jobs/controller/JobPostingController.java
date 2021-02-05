package com.harleeninfo.venkatsai.jobs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.harleeninfo.venkatsai.jobs.entity.RecProfile;
import com.harleeninfo.venkatsai.jobs.entity.RecProfileJob;
import com.harleeninfo.venkatsai.jobs.service.ComenyDtBoService;
import com.harleeninfo.venkatsai.jobs.vo.CommanResponsVo;
import com.harleeninfo.venkatsai.jobs.vo.RecProfileJobVo;
import com.sun.xml.messaging.saaj.util.Base64;
import com.sun.xml.messaging.saaj.util.ByteInputStream;
@Controller
public class JobPostingController {
	   @Autowired
	    ComenyDtBoService commDtService;
	private static String UPLOADED_FOLDER = "C://images//";
	  @RequestMapping(value = "/postByRecruiter", method = RequestMethod.GET)
	    public String registration(Model model) throws UnsupportedEncodingException
	    {
		  
		  File j=new File("C:\\images\\8.jpg");
		  byte[] bArray = new byte[(int) j.length()];
		  byte[] encodeBase64 = new byte[(int) j.length()];
          String base64Encoded = new String(encodeBase64, "UTF-8");
          model.addAttribute("userImage", base64Encoded );
	        model.addAttribute("postingJob", new RecProfileJob());
	        return "postByRecruiter";
	    }
	
	  @RequestMapping(value = "/postByRecruiter", method = RequestMethod.POST)
	    public String jobPosting(@ModelAttribute("postingJob") RecProfileJobVo companyForm, BindingResult bindingResult, Model model)
	    {
	      
		  System.out.println("+++++++++++++++++++++++"+companyForm.getFile());
			// read and write the file to the selected location-
//				byte[] bytes = file.getBytes();
//				Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
//				Files.write(path, bytes);
		  
		  RecProfileJob data=new RecProfileJob();
		  data.setCompanyname(companyForm.getCompanyname());
		  data.setCompanyemail(companyForm.getCompanyemail());
		  data.setMobileno(companyForm.getMobileno());
		  data.setJobtype(companyForm.getJobtype());
		  
		  
		  try {

	            // Get the file and save it somewhere
	            byte[] bytes = companyForm.getFile().getBytes();
	            
	            ;
	          
	           
	            Path path = Paths.get(UPLOADED_FOLDER+UUID.randomUUID().toString()+".jpg");
	            Files.write(path, bytes);
	           
//	            redirectAttributes.addFlashAttribute("message",
//	                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  data.setImageNmae(UUID.randomUUID().toString()+".jpg");
		  HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        HttpEntity entity = new HttpEntity(data, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        //System.out.println((new StringBuilder()).append(id).toString());
	        ResponseEntity<CommanResponsVo> response = restTemplate.exchange("http://localhost:8890/jobsPosting", HttpMethod.POST, entity, CommanResponsVo.class);
	           CommanResponsVo comm = response.getBody();
	      //  System.out.println(response.);
	        if(comm.getStatus().equals("true"))
	            return "postByRecruiter";
	        else
	            return "postByRecruiter";
	    	
	           
	    }
	  @RequestMapping(value = {"/recruiterDashboard"}, method = RequestMethod.GET)
	    public String recruiterDashboard(Model model) {
		  List<RecProfile> products = commDtService.findByUser("");        
		  String pageName = null;
          
          if(products.size()>0) {
         	 model.addAttribute("products", products); 
         	 pageName ="recruiterDashboard";
          }else {
         	 model.addAttribute("title", "Admin DashBoard"); 
         	 model.addAttribute("erroe", "NO DATA FOUND"); 
         	 pageName="dataError";
          }
	        return "recruiterDashboard";
	    }
	  
	  @RequestMapping(value = {"/recruiterProfile"}, method = RequestMethod.GET)
	    public String recruiterProfile(Model model) {
		  
		  List<RecProfile> products = commDtService.findByUser("");        
		  String pageName = null;
          
          if(products.size()>0) {
         	 model.addAttribute("products", products); 
         	 pageName ="recruiterProfile";
          }else {
         	 model.addAttribute("title", "Admin DashBoard"); 
         	 model.addAttribute("erroe", "NO DATA FOUND"); 
         	 pageName="dataError";
          }
		  
	        return pageName;
	    }
}
