package com.idrice24.controllers;

import java.util.ArrayList;
import java.util.List;
import java.servlet.http.HttpServletRequest;
import java.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringSessionController{
	@GetMapping("/")
	public String process(Model model, HttpSession session){
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		if(messages == null){
			messages = new ArrayList<>();
		}
		model.addAttribute("sessionMessages", messages);
		return "index";
	}
@PostMapping("/persistMessage")
public String persistMessage(@RequestMapping("msg") String msg, HttpServletRequest request){
	@SuppressWarnings("unchecked")
	List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
	if(messages == null){
		messages= new ArrayList<>();
		request.getSession.setAttribute("MY_SESSION_MESSAGES");
	}
	messages.add(msg);
	request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
	return "redirect:/";
}
@PostMapping("/destroy")
public String destroySession(HttpServletRequest request){
	request.getSession().invalidate();
	return "redirect:/";
}
}
