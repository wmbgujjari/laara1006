package com.harleeninfo.venkatsai.jobs.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.harleeninfo.venkatsai.jobs.service.ClientAddsService;
import com.harleeninfo.venkatsai.jobs.service.ComenyDtBoService;
import com.harleeninfo.venkatsai.jobs.service.UserService;
import com.harleeninfo.venkatsai.jobs.validator.UserValidator;
import com.harleeninfo.venkatsai.vo.AddsVo;
import com.harleeninfo.venkatsai.vo.ApplyJob;
import com.harleeninfo.venkatsai.vo.ApplyJobVo;
import com.harleeninfo.venkatsai.vo.CommanResponsVo;
import com.harleeninfo.venkatsai.vo.RecProfileJobVo;
@Controller
public class ApplyJobsController {
	  @Autowired
	    private UserService userService;
	    @Autowired
	    ClientAddsService clientAddsSerice;

	    @Autowired
	    private UserValidator userValidator;
	    private static String UPLOADED_FOLDER = "C:\\images\\";
	    @Autowired
	    ClientAddsService clientaddService;
	    
	    @Autowired
	    ComenyDtBoService commDtService;
	 @RequestMapping(value = "/applyjob", method = RequestMethod.POST)
	    public String applyJob(@ModelAttribute("applyjob") ApplyJobVo applyJob, BindingResult bindingResult, Model model)
	    {
		 try {
			 String imageUid=UUID.randomUUID().toString();
			 byte[] bytes = applyJob.getCv().getBytes();
	            
	           
	          
	          
	            Path path1 = Paths.get(UPLOADED_FOLDER+imageUid+".docx");
	            Files.write(path1, bytes);
			 
    		 List<RecProfileJobVo> profile=new ArrayList<RecProfileJobVo>();
    	String com = commDtService.getJpobPostingByid("1");
    //	 Map profile12=(LinkedHashMap<String, String>) com.getRespons();
    	JSONObject obj=new JSONObject(com);
    	JSONArray array = obj.getJSONArray("respons");
    	MultipartFile mf =null;
    	for(int i=0;i<array.length();i++) {
    		RecProfileJobVo vo=new RecProfileJobVo();
    		Path path = Paths.get(UPLOADED_FOLDER+array.getJSONObject(i).getString("imageNmae"));
	         byte[] by = Files.readAllBytes(path); 
	         String encoded = Base64.getEncoder().encodeToString(by);
	         String base64Encoded = new String(encoded);
	         vo.setCompanyemail(array.getJSONObject(i).getString("companyemail")); 
	         vo.setId(array.getJSONObject(i).getLong("id")); 
	         vo.setCompanyname(array.getJSONObject(i).getString("companyname"));
	         vo.setDescr(array.getJSONObject(i).getString("descr"));
	         vo.setImageNmae(base64Encoded);
	         profile.add(vo);
    	}
    	
    	String addsList = clientAddsSerice.getAllAdds();
    	JSONObject addsobj=new JSONObject(addsList);
    	JSONArray addsarray = addsobj.getJSONArray("respons");
    	List<AddsVo> addsListe=new ArrayList<AddsVo>();
    	for(int j=0;j<addsarray.length();j++) {
    		AddsVo addsVo=new AddsVo();
    		Path path = Paths.get(UPLOADED_FOLDER+addsarray.getJSONObject(j).getString("imageName"));
	         byte[] by = Files.readAllBytes(path); 
	         String encoded = Base64.getEncoder().encodeToString(by);
	         String base64Encoded = new String(encoded);
	         addsVo.setImageName(base64Encoded);
	         addsVo.setAddsId(addsarray.getJSONObject(j).getLong("addsId"));
	         addsListe.add(addsVo);

    	}
    	
    	ApplyJob appjob=new ApplyJob();
    	appjob.setJob_id(Integer.parseInt(applyJob.getPostId()));
    	appjob.setSeekercv(imageUid);
    	appjob.setSeekermobile(applyJob.getMobileNumber());
    	appjob.setSeekermail(applyJob.getEmailId());
         model.addAttribute("addesList", addsListe);
    	 model.addAttribute("profile", profile);
    	 
    	  HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        HttpEntity entity = new HttpEntity(appjob, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        //System.out.println((new StringBuilder()).append(id).toString());
	        ResponseEntity<CommanResponsVo> response = restTemplate.exchange("http://localhost:8890/applyjob", HttpMethod.POST, entity, CommanResponsVo.class);
	           CommanResponsVo comm = response.getBody();
	      //  System.out.println(response.);
	        if(comm.getStatus().equals("true"))
	            return "welcome";
	        else
	            return "welcome";
    	
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
			// TODO: handle exception
		}
        return "welcome";
	    }
}
