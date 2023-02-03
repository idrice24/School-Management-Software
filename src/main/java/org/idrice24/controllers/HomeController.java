package org.idrice24.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class HomeController{

	public HomeController(){

    }

    @GetMapping("home/app")
    public String homePage(){
        return "home";
    }	
}