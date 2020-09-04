package com.idrice24.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.idrice24.entities.User;
import com.idrice24.services.UserService;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView begin() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("login");
		return login();
    }

    @GetMapping("/login")
    public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
    }

    @GetMapping("index")
    public ModelAndView myindex(){
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index");
    	return modelAndView;
    }

    @GetMapping(value = "/registration")
    public ModelAndView registration() {

	logger.info("registration CALLED");

	ModelAndView modelAndView = new ModelAndView();

	// Create a model user
	User user = new User();

	// Set up model
	modelAndView.addObject("user", user);

	// Set up View
	modelAndView.setViewName("registration");

	// Return the model and his view!!
	return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	ModelAndView modelAndView = new ModelAndView();

	logger.info(user.getEmail());
	logger.info("" + bindingResult.getErrorCount());
	for (ObjectError er : bindingResult.getAllErrors()) {
	    logger.info(er.getDefaultMessage());
	}
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

}
