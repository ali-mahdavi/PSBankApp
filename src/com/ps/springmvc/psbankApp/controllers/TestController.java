package com.ps.springmvc.psbankApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value={"","index*","view/*"})	
	 public String register(){
		 return "testRequestMapping";
	 }
	
	@RequestMapping(value={"/name"})	
	 public String methoWithParams(@RequestParam(value="username",
	                                             required=false,
	                                             defaultValue="ahmad") String username,Model model){
		System.out.println("page requested by"+ username); 
		model.addAttribute("username", username);
		return "testRequestMapping";
	 }
	
	@RequestMapping(value={"/dynamic/{category:[a-z]+}/{username}"})	
	 public String dynamicUrl(@PathVariable("username") String username){
		
		return "testRequestMapping";
	 }
	
	@RequestMapping("*")	
	 public String fallBackPage(){
		
		return "filNotFound";
	 }
}
