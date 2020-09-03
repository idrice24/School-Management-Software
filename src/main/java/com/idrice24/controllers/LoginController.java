package com.idrice24.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idrice24.entities.User;
import com.idrice24.services.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView Begin() {
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("login");
	  return modelAndView;
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login() {
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("login");
	  return modelAndView;
    }

    @GetMapping(value = { "/index" })
    // @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public ModelAndView Myindex() {
   	ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("index");
	  return modelAndView;
    }
  
    @RequestMapping(value = { "/files/studentboard" }, method = RequestMethod.GET)
    public ModelAndView Mystudentboard() {
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("files/studentboard");
	  return modelAndView;
    }

    @RequestMapping(value = { "/files/helpboard" }, method = RequestMethod.GET)
    public ModelAndView Myhelpboard() {
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("files/helpboard");
	   return modelAndView;
    }


    @RequestMapping(value = { "/files/publicboard" }, method = RequestMethod.GET)
    public ModelAndView Mypublicboard() {
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("files/publicboard");
	  return modelAndView;
    }


    @RequestMapping(value = { "/files/parentsboard" }, method = RequestMethod.GET)
    public ModelAndView Myparentsboard() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("files/parentsboard");
	return modelAndView;
    }



    @RequestMapping(value = { "/files/schoolboard" }, method = RequestMethod.GET)
    public ModelAndView Myschoolboard() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("files/schoolboard");
	return modelAndView;
    }


    @RequestMapping(value = { "/files/settingboard" }, method = RequestMethod.GET)
    public ModelAndView Mysettingboard() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("files/settingboard");
	return modelAndView;
    }

    @GetMapping(value = "/files/teacherboard")
    public ModelAndView monteacherboard() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("files/teacherboard");
	return modelAndView;
    }


    @RequestMapping(value = { "/files/tutorialboard" }, method = RequestMethod.GET)
    public ModelAndView Mytutorialboard() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("files/tutorialboard");
	return modelAndView;
    }

    @GetMapping(value = "/registration")
    public ModelAndView registration() {

	ModelAndView modelAndView = new ModelAndView();

	// Create a model user
	User user = new User();

	// Set up model
	modelAndView.addObject("user", user);
	// Set up View
	modelAndView.setViewName("registration");
	return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	ModelAndView modelAndView = new ModelAndView();
	User userExists = userService.findUserByEmail(user.getEmail());
	if (userExists != null) {
	    bindingResult.rejectValue("email", "error.user",
		    "There is already a user registered with the email provided");
	}
	if (bindingResult.hasErrors()) {
	    modelAndView.setViewName("registration");
	} else {
	    userService.saveUser(user);
	    modelAndView.addObject("successMessage", "User has been registered successfully");
	    modelAndView.addObject("user", new User());
	    modelAndView.setViewName("registration");

	}
	return modelAndView;
    }

    @GetMapping(value = "/admin/home")
    public ModelAndView home() {
	ModelAndView modelAndView = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	modelAndView.addObject("userName",
		"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
	modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
	modelAndView.setViewName("admin/home");
	return modelAndView;
    }

}
