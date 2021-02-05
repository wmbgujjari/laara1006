package com.harleeninfo.venkatsai.jobs.controller;


import com.harleeninfo.venkatsai.jobs.service.EmailService;
import com.harleeninfo.venkatsai.jobs.service.OTPService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.harleeninfo.venkatsai.jobs.service.ComenyDtBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.harleeninfo.venkatsai.jobs.entity.OtpUser;
import com.harleeninfo.venkatsai.jobs.entity.User;
import com.harleeninfo.venkatsai.jobs.service.UserService;
import com.harleeninfo.venkatsai.jobs.validator.UserValidator;
import com.harleeninfo.venkatsai.jobs.vo.CommanResponsVo;
import com.harleeninfo.venkatsai.jobs.vo.RecProfileJobVo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    public OTPService otpService;

    @Autowired
    ComenyDtBoService commDtService;
    
    @Autowired
    public EmailService emailService;

 
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(@ModelAttribute("userForm") User user,Model model) {
        model.addAttribute("userForm", new User());
    	//model.addAttribute("xyz", "xyz");
        return "registration";
    }

  
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	model.addAttribute("userForm", new User());
        userValidator.validate(userForm, bindingResult);
        System.out.println("out"+userForm.getUsername());
/*        if (bindingResult.hasErrors()) {
            return "registration";
        }*/

        userService.save(userForm);

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	try {
        	CommanResponsVo com = commDtService.getJpobPostingByid("1");
        	 List<RecProfileJobVo> profile=(List<RecProfileJobVo>) com.getRespons();
        	 model.addAttribute("profile", profile);
        	
        	}catch (Exception e) {
        		System.out.println(e.getMessage());
    			// TODO: handle exception
    		}
            return "welcome";
    }
}

