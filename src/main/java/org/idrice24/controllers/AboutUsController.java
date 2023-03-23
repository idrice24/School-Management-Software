package org.idrice24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.idrice24.entities.Aboutus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/about-us/")
public class AboutUsController{

    @GetMapping("show")
    public String show(Model model, Aboutus aboutus){
        model.addAttribute("aboutus", aboutus);
        return "aboutus";
    }

}