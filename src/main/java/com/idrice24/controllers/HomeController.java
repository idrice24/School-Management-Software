package org.idrice24.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomeController{
	
	@Autowired
	public HomeController(){

	}

	@GetMapping("index")
	public String IndexPage(){
		return "index";
	}

	@GetMapping("home")
	public String HomePage(){
		return "home";
	}

	@GetMapping("user/login")
	public String Ulong(){
		return "login";
	}

	@GetMapping("admin/login")
	public String Login(){
		return "alogin";
	}

	@GetMapping("user/register")
	public String Register(){
		return "register";
	}

	@GetMapping("student/login")
	public String Slogin(){
		return "slogin";
	}

	@GetMapping("parent/login")
	public String Plogin(){
		return "plogin";
	}
	@GetMapping("teacher/login")
	public String Tlogin(){
		return "tlogin";
	}

	@GetMapping("media/image")
	public String image(){
		return "album";
	}
	@GetMapping("media/video")
	public String video(){
		return "video";
	}
	@GetMapping("contact")
	public String Contact(){
		return "contact";
	}

	@GetMapping("about-us")
	public String AboutUs(){
		return "about-us";
	}

	@GetMapping("media")
	public String Media(){
		return "media";
	}
	
	

}