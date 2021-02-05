package com.harleeninfo.venkatsai.jobs.controller;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.harleeninfo.venkatsai.jobs.entity.Comments;
import com.harleeninfo.venkatsai.jobs.entity.OtpUser;
import com.harleeninfo.venkatsai.jobs.entity.User;
import com.harleeninfo.venkatsai.jobs.service.CommentsService;
import com.harleeninfo.venkatsai.jobs.vo.RecProfileJobVo;



@Controller
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	

	@RequestMapping(value ="/comments", method = RequestMethod.POST)
	    public String jobPosting(@ModelAttribute("comment") Comments comments, BindingResult bindingResult, Model model)
	    {
    	model.addAttribute("comments", new Comments());
		//model.addAttribute("xyz", "xyz");
    	comments.setRecordStatus("Active");
    	commentsService.save(comments);
		  // System.out.println("raju welcome to ajax"+comments.getPostId());
		   return "redirect:/welcome";
	}

}
