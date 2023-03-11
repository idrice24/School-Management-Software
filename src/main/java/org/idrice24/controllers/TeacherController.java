package org.idrice24.controllers;

import java.sql.Date;

import javax.validation.Valid;

import org.idrice24.entities.Teachers;
import org.idrice24.repositories.TeacherRepository;
import org.idrice24.services.ClasseService;
import org.idrice24.services.CourseService;
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
@RequestMapping("/teachers/")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;
    private ClasseService classeService;
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService, ClasseService classeService, TeacherRepository teacherRepository){
        this.teacherService = teacherService;
        this.courseService = courseService;
        this.classeService = classeService;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("teacher/signup")
    public String ViewTeacher(Model model, Teachers teachers){
        model.addAttribute("courses", courseService.listAllCourses());
        model.addAttribute("classes", classeService.getAllClasse());
        return "add-teacher";
    }

    @GetMapping("teacher/list")
    public String showTeacher(Model model){
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers";
    }

    @PostMapping("add/teacher")
    public String addteacher(@Valid Teachers teacher, BindingResult result, Model model ){
        if(result.hasErrors()){
            return "add-teacher";
        }
        Date d = new Date(0);
        teacher.setJndate(d);
        Teachers t = teacherRepository.save(teacher);
        long u = t.getId();
        String s = "TUI00" + u;
        if(s != teacher.getSui()){
            s = "TUI000" + u;
        }
        teacher.setSui(s);
        teacherService.saveTeacher(teacher);
        model.addAttribute("teachers", teacherService.getAllTeachers());
        model.addAttribute("classes", classeService.getAllClasse());
        model.addAttribute("courses", courseService.listAllCourses());
        return "teachers";
    }

    @GetMapping("edit/teacher/{id}")
    public String editTeacher(@PathVariable("id") long id, Model model, BindingResult result, Teachers teachers){
        teachers = (teacherService.findById(id));
        if(result.hasErrors()){
            return "teachers";
        }
        model.addAttribute("teacher", teachers);
        return "update-teacher";
    }
    
    @PostMapping("updtae/teacher/{id}")
    public String updateTeacher(@PathVariable("id") long id, Model model, Teachers teachers, BindingResult result){
        if(result.hasErrors()){
            teachers.setId(id);
            return "update-teacher";
        }

        teacherService.saveTeacher(teachers);
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers";
    }

    @GetMapping("delete/teacher/{id}")
    public String deleteTeacher(@PathVariable("id") long id, Model model, Teachers teachers){
        teachers = (teacherService.findById(id));
        teacherService.deleteTeacher(teachers);
        return "teachers";
    }

    @GetMapping("view/teacher/{id}")
    public String viewTeacher(@PathVariable("id") long id, Model model, Teachers teachers){
        teachers = (teacherService.findById(id));
        model.addAttribute("teacher", teachers);
        return "view-teacher";
    }
    
}
