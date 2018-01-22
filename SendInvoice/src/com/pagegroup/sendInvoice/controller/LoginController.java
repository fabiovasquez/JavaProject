package com.pagegroup.sendInvoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pagegroup.sendInvoice.dao.Authentication;

@Controller
public class LoginController {
	
	@RequestMapping("/Login")
	public String login(){
		
		Authentication authentication = new Authentication();
		
		return "Home/Index";		
	}
}
