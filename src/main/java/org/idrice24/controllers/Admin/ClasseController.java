package org.idrice24.controllers.Admin;

import javax.validation.Valid;

import org.idrice24.entities.Admin.Classe;
import org.idrice24.services.Admin.ClasseService;
import org.idrice24.services.Students.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classes/")
public class ClasseController {
    private final ClasseService classeService;
    private StudentService studentService;

    @Autowired
    public ClasseController(ClasseService classeService, StudentService studentService){
        this.classeService = classeService;
        this.studentService = studentService;
    }

    @GetMapping(value="classe")
    public String viewPage(Model model, Classe addClasse){
        model.addAttribute("addClasse", classeService.getAllClasse());
        return "add-classe";
    }

    @GetMapping("classe/list")
    public String showClasse(@Valid Classe classe, Model model){
        model.addAttribute("classes", classeService.getAllClasse());
        return "classe";
    }

    @PostMapping("classe/add")
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
            classe.setId(id);
            return "classe";
        }
        model.addAttribute("classe", classe);
        return "classe";
    }

    @GetMapping("update/classe/{id}")
    public String updateClasse(@PathVariable("id") long id, Model model, Classe classe, BindingResult result){
        if(result.hasErrors()){
            classe.setId(id);
            return "classe";
        }
        classeService.saveClasse(classe);
        model.addAttribute("classes", classeService.getAllClasse());
        return "classe";
    }

    @GetMapping("delete/classe/{id}")
    public String deleteClasse(@PathVariable("id") long id, Model model, Classe classe, BindingResult result){
        classe = classeService.getClasseById(id);
        if(result.hasErrors()){
            classe.setId(id);
            return "classe";
        }
        classeService.deleteClasse(classe);
        return "classe";
    }

    @GetMapping("view/classe/{id}")
    public String viewClasse(@PathVariable("id") long id, Model model){
        Classe classe = classeService.getClasseById(id);
        String classeName = classe.getClassename();
        model.addAttribute("classes", classe);
        System.out.println(classeName);
        return "classeview";
    }

    @GetMapping("view/subject/classe/{id}")
    public String subjectClasse(@PathVariable("id") long id, Model model){
        Classe classes = classeService.getClasseById(id);
        model.addAttribute("classes", classes);
       // Class<? extends Classe> s = c.getClass();
        model.addAttribute("students", studentService.listAllStudents());
        return "classeview";
    }

    @PostMapping("class/list/{ciu}")
    public String classList(@PathVariable("ciu") String classe_name, Model model){
        System.out.println(classe_name);
        return null;
    }



}
