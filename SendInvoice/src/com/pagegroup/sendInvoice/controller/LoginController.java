package com.pagegroup.sendInvoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pagegroup.sendInvoice.data.Authentication;
import com.pagegroup.sendInvoice.model.LoginViewModel;

@Controller
public class LoginController {
	
	@RequestMapping("/Login")
	public String login(LoginViewModel login){
		
		Authentication aut = new Authentication();
				
	
		return "Home/Index";		
	}
}
