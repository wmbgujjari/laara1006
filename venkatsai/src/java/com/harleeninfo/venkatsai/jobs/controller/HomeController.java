package com.harleeninfo.venkatsai.jobs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harleeninfo.venkatsai.jobs.entity.User;
import com.harleeninfo.venkatsai.jobs.service.OTPService;



@Controller
public class HomeController {
    @Value("${spring.application.name}")
    String appName;
    
    @Autowired
    public OTPService otpService;
    @GetMapping("/")
    public String homePage(Model model) {
    String message = " Welcome to Home Page";
    System.out.println(message);
        model.addAttribute("appName", appName);
        model.addAttribute("message", message);
        return "signin";
    }
    @GetMapping("/dashboard")
    public String dashboard(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        //logger.info("username: " + auth.getName()); 

    return "dashboard";
    }
   /* @GetMapping("/login")
    public String login() {
        return "signin";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }*/
    
   /* @RequestMapping(value = "/otpRegistration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "otpRegistration";
    }*/
    
    @GetMapping("/otppage")
    public String otppage() {
        return "otppage";
    }    
    @GetMapping("/aboutus")
    public String about() {
        return "aboutus";
    }
    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public @ResponseBody String logout(HttpServletRequest request, HttpServletResponse response){
       Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
       if (auth != null){    
       String username = auth.getName();
       //Remove the recently used OTP from server. 
       otpService.clearOTP(username);
       new SecurityContextLogoutHandler().logout(request, response, auth);
       }
   return "redirect:/login?logout";    
    }
}