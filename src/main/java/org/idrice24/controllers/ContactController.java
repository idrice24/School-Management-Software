package org.idrice24.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import org.idrice24.entities.Contact;
import org.idrice24.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/contact/")
public class ContactController{
    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService){
        this.contactService = contactService;
    }

@GetMapping("show")
public String showContact(Model model, Contact contact){
model.addAttribute("contact", contact);
    return "contact";
}

@GetMapping("contactform/send")
public String SendContactForm(@Valid long id, Model model, BindingResult result, Contact contact){
    if(result.hasErrors()){
        return "contact";
    }
    contactService.saveContact(contact);
    model.addAttribute("contact", contact);
    return "contact";
}

@GetMapping("contact/delete/{id}")
public String deleteContact(@PathVariable("id") long id, Model model, BindingResult result, Contact contact){
    contact = contactService.getContactById(id);
    contactService.deleteContact(contact);
    model.addAttribute("contact", contact);
    return "contact";
}

}