package com.harleeninfo.venkatsai.jobs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.harleeninfo.venkatsai.jobs.entity.OtpUser;
import com.harleeninfo.venkatsai.jobs.entity.User;
import com.harleeninfo.venkatsai.jobs.service.EmailService;
import com.harleeninfo.venkatsai.jobs.service.OTPService;
import com.harleeninfo.venkatsai.jobs.service.UserService;


@Controller
public class OTPController {
	

@Autowired
public OTPService otpService;

@Autowired
private UserService userService;

@Autowired
public EmailService emailService;



@RequestMapping(value = "/otpRegistration", method = RequestMethod.GET)
public String registration(@ModelAttribute("otpForm") OtpUser user,Model model) {
    model.addAttribute("otpForm", new OtpUser());
	//model.addAttribute("xyz", "xyz");
    return "otpRegistration";
}    




 

@RequestMapping(value = "/otpConfirm", method = RequestMethod.GET)
public String otpConfirm(Model model,HttpServletRequest request,HttpServletResponse response) throws MessagingException {
    model.addAttribute("otpForm", new OtpUser());

    

    String Email=(String) request.getSession().getAttribute("Email");
    System.out.println("Email"+Email);
	//Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
	//String username = auth.getName();
	//System.out.println("usern ame"+username);
	int otp = otpService.generateOTP(Email);
	System.out.println("otppppp"+otp);
	//Generate The Template to send OTP 
	EmailTemplate template = new EmailTemplate("SendOtp.html");
	Map<String,String> replacements = new HashMap<String,String>();
	replacements.put("user", Email);
	replacements.put("otpnum", String.valueOf(otp));
	String message = template.getTemplate(replacements);
	emailService.sendOtpMessage(Email, "OTP -SpringBoot", message);
    
    
    
    return "otpConfirm";
}


@RequestMapping(value="/forgotpassword", method = RequestMethod.GET)
public String confirmOtp(@RequestParam int otpnum,Model model,HttpServletRequest request,HttpServletResponse response) {

    //String user =user ; //use it further;
	String Email=(String) request.getSession().getAttribute("Email");
	System.out.print("dfsdfsd"+otpnum);
	final String SUCCESS = "Entered Otp is valid";
	final String FAIL = "Entered Otp is NOT valid. Please Retry!";
	//Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
	//String username = auth.getName();
	System.out.println("testing OPT"+FAIL);
	//Validate the Otp 
	if(otpnum >= 0){
		
	  int serverOtp = otpService.getOtp(Email);
	    if(serverOtp > 0){
	      if(otpnum == serverOtp){
	          otpService.clearOTP(Email);
	          System.out.println("testing OPT"+SUCCESS);
	          
	          model.addAttribute("userForm", new User());
	          model.addAttribute("Email", Email);
	         // return "registration";
	          return "redirect:/registration";
            } 
	        else {
                return "otpConfirm";
               }
           }else {
          return "otpConfirm";
           }
         }else {
            return "otpConfirm";
     }
}

@RequestMapping(value = "/otpRegistration", method = RequestMethod.POST)
public String otpregistration(@ModelAttribute("otpForm") OtpUser otpForm, BindingResult bindingResult, Model model,HttpServletRequest request,HttpServletResponse response) {
   /* userValidator.validate(otpForm, bindingResult);

    if (bindingResult.hasErrors()) {
    	//ModelAndView modelAndView = new ModelAndView("otpRegistration");
        return "otpRegistration";
    }*/

    userService.saveotp(otpForm);
    //request.setAttribute("Email", otpForm.getEmail());
    request.getSession().setAttribute("Email", otpForm.getEmail());
    model.addAttribute("otpForm", new OtpUser());
    return "redirect:/otpConfirm";
}

}
