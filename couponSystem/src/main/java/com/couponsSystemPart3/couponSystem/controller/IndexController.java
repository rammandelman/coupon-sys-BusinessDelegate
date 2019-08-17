package com.couponsSystemPart3.couponSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	

	@RequestMapping("/")
	public String HelloPage(Model model) {
		model.addAttribute( "welcome","welcome to jhon bryce emailsys");
		
		return "login";
	}

}
