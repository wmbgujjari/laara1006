package com.harleeninfo.venkatsai.jobs.controller;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harleeninfo.venkatsai.jobs.entity.RecProfileJob;
import com.harleeninfo.venkatsai.jobs.entity.User;
import com.harleeninfo.venkatsai.jobs.service.ComenyDtBoService;
import com.harleeninfo.venkatsai.jobs.service.UserService;
import com.harleeninfo.venkatsai.jobs.validator.UserValidator;
import com.harleeninfo.venkatsai.vo.CommanResponsVo;
import com.harleeninfo.venkatsai.vo.RecProfileJobVo;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    ComenyDtBoService commDtService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

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

