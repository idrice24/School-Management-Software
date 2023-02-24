package org.idrice24.controllers;

import javax.validation.Valid;

import org.idrice24.entities.Classe;
import org.idrice24.services.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classe/")
public class ClasseController {
    private final ClasseService classeService;

    @Autowired
    public ClasseController(ClasseService classeService){
        this.classeService = classeService;
    }

    @GetMapping("classe")
    public String viewPage(){

        return "add-classe";
    }

    @GetMapping("classe/list")
    public String showClasse(@Valid Classe classe, Model model){
        model.addAttribute("classes", classeService.getAllClasse());
        return "classe";
    }

    @PostMapping("add/class")
    public String newClasse(@Valid Classe classe, Model model, BindingResult result){
        if(result.hasErrors()){
            return "add-classe";
        }
        classeService.saveClasse(classe);
        model.addAttribute("classes", classeService.getAllClasse() );
        return "classe";
    }

    @GetMapping("edit/classe/{id}")
    public String editClasse(@PathVariable("id") long id, Model model,BindingResult result, Classe classe ){
        if(result.hasErrors()){
            return "classe";
        }
        model.addAttribute("classe", classe);
        return "classe";
    }

    @GetMapping("update/classe/{id}")
    public String updateClasse(@PathVariable("id") long id, Model model, Classe classe, BindingResult result){
        if(result.hasErrors()){
            classe.setClasseId(id);
            return "classe";
        }
        classeService.saveClasse(classe);
        model.addAttribute("classes", classeService.getAllClasse());
        return "classe";
    }
}
