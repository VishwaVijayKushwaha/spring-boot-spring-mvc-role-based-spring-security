package com.vishwavijay.sample.springbootspringmvcspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class UiController {
	
	
	@RequestMapping("/home")
	public String getHomePage(Model model) {
		model.addAttribute("page", "home-page");
		return "home-page";
	}
	
	@RequestMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("page", "it's a login page.");
		return "login-page";
	}
	
	@RequestMapping("/error")
	public String getErrorPage(Model model) {
		model.addAttribute("page", "its a error page.");
		return "error-page";
	}
	
}
