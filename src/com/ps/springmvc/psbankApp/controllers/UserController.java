package com.ps.springmvc.psbankApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@RequestMapping("/new")
	public String register() {
		return "register";
	}
	

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model mode) {
		if(error!=null) {
			mode.addAttribute("error","Invalid username or password");
		}
		if(logout!=null) {
			mode.addAttribute("msg","logout successful");
		}
		
		return "login";
	}
	
}
