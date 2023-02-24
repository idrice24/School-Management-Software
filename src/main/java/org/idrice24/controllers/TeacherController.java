package org.idrice24.controllers;

import javax.validation.Valid;

import org.idrice24.entities.Teachers;
import org.idrice24.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("teacher")
    public String ViewTeacher(){
        return "add-teacher";
    }

    @GetMapping("teacher/list")
    public String showTeacher(Model model){
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacher";
    }

    @PostMapping("add/teacher")
    public String addteacher(@Valid Teachers teacher, BindingResult result, Model model ){
        if(result.hasErrors()){
            return "add-teacher";
        }
        teacherService.saveTeacher(teacher);
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacher";
    }

    @GetMapping("edit/teacher/{id}")
    public String editTeacher(@PathVariable("id") long id, Model model, BindingResult result, Teachers teachers){
        teachers = (teacherService.findById(id));
        if(result.hasErrors()){
            return "teacher";
        }
        model.addAttribute("teacher", teachers);
        return "update-teacher";
    }
    
    @PostMapping("updtae/teacher/{id}")
    public String updateTeacher(@PathVariable("id") long id, Model model, Teachers teachers, BindingResult result){
        if(result.hasErrors()){
            teachers.setTeacherId(id);
            return "update-teacher";
        }

        teacherService.saveTeacher(teachers);
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacher";
    }

    @GetMapping("delete/teacher/{id}")
    public String deleteTeacher(@PathVariable("id") long id, Model model, Teachers teachers){
        teachers = (teacherService.findById(id));
        teacherService.deleteTeacher(teachers);
        return "teacher";
    }

    @GetMapping("view/teacher/{id}")
    public String viewTeacher(@PathVariable("id") long id, Model model, Teachers teachers){
        teachers = (teacherService.findById(id));
        model.addAttribute("teacher", teachers);
        return "view-teacher";
    }
    
}
