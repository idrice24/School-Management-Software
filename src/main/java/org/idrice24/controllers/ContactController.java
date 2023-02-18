package org.idrice24.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import org.idrice24.entities.Contact;
import org.idrice24.services.ContactService;

@Controller
@RequestMapping("/contact/")
public class ContactController{

	private ContactService contactService;


}