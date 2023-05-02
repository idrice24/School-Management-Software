package org.idrice24.controllers;

import javax.validation.Valid;

import org.idrice24.entities.Course;
import org.idrice24.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/courses/")
public class CourseController{
    private final CourseService courseService;


    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping(value="course")
    public String getCourseView(Model model){
        model.addAttribute("course", model);
        return "add-course";
    }

    @GetMapping(value="course/list")
    public String getCourseList(Model model){
        model.addAttribute("courses", courseService.listAllCourses());
        return "course";
    }

    @PostMapping(value="course/add")
    public String addNewCourse(@Valid Course course, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-course";
        }

        courseService.saveCourse(course);
        model.addAttribute("courses", courseService.listAllCourses());
        return "course";
    }
    @GetMapping("course/edit/{id}")
    public String editCourse(@PathVariable("id") long id, Course course, Model model, BindingResult result){
        course = courseService.findById(id);
        model.addAttribute("course", course);

        return "update-course";
    }

    @PostMapping(value = "course/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Course course, Model model, BindingResult result){
        if(result.hasErrors()){
            course.setId(id);
            return "update-course";
        }

        courseService.saveCourse(course);
        model.addAttribute("courses", courseService.listAllCourses());
        return "course";
    }

}