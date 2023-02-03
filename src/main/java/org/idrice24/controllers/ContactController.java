package org.idrice24.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;


import org.idrice24.entities.Contact;
import org.idrice24.services.ContactService;

@Controller
@RequestMapping("/contact/")
public class ContactController{

	private ContactService contactService;

	public void setContactService(ContactService contactService){
		this.contactService = contactService;
	}

	@GetMapping("contactform")
	public String showForm(Contact contact, BindingResult result){
		if(result.hasErrors()){
			return "contact";
		}
		return "contact";
	}

	@PostMapping("contactform/send")
	public String sendContact(@Valid Contact contact, Model model, BindingResult result){
		if(result.hasErrors()){
			return "contact";
		}
		model.addAttribute("noErrors", true);
		model.addAttribute("contact", contact);
		String subject = contact.getName() + " " + contact.getEmail() + " send you a message";
		contactService.sentContact(subject, contact.getMessage());
		return "contact";
	}


}