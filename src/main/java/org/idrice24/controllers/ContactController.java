package org.idrice24.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/contact/")
public class ContactController{

	public ContactController(){

	}

	@GetMapping("contactform")
	public String contactForm(){
		return "contact";
	}


}