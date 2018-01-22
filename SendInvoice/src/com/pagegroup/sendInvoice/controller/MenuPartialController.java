package com.pagegroup.sendInvoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuPartialController {
		
		@RequestMapping("_MenuPartial")
		public String MenuPartial(){
			return "Shared/_MenuPartial";
		}
}
