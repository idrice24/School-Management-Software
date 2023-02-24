package org.idrice24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class HomeController{

	public HomeController(){

    }

    @GetMapping(value="home/app")
    public String homePage(Model model){
        
        return "home";
    }	
}