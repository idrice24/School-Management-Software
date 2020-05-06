package com.idrice24.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idrice24.entities.Teacher;
import com.idrice24.services.TeacherService;
import com.idrice24.repositories.TeacherRepository;

import com.idrice24.entities.School;
import com.idrice24.services.SchoolService;

import com.idrice24.entities.Course;
import com.idrice24.services.CourseService;

import com.idrice24.entities.Classe;
import com.idrice24.services.ClasseService;

@Controller
public class TeacherController {

	private final TeacherService TeacherService;
	private CourseService CourseService;
	private ClasseService ClasseService;
	private SchoolService SchoolService;

	private TeacherRepository teacherRepository;

	@Autowired
	public TeacherController(TeacherService TeacherService) {
		this.TeacherService = TeacherService;
	}
	@Autowired
	public void CourseController(CourseService CourseService){
		this.CourseService = CourseService;
	}
	@Autowired
	public void SchoolController(SchoolService SchoolService){
		this.SchoolService = SchoolService;
	}
	@Autowired
	public void ClasseController(ClasseService ClasseService){
		this.ClasseService = ClasseService;
	}
	@Autowired
	public void TeacherController(TeacherRepository teacherRepository){
		this.teacherRepository = teacherRepository;
	}


	@RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("teachers", TeacherService.listAllTeachers());
        System.out.println("Returning teachers:");
        return "teachers";
    }
	@RequestMapping("teacher/view/{id}")
    public String showTeacher(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", TeacherService.getTeacherById(id));
        return "teachershow";
    }

	@GetMapping("teacher/list")
	public String showTeachlistsForm(Model model) {
		model.addAttribute("teachers", TeacherService.listAllTeachers());
		return "teacherview";
	}


    @RequestMapping("teacher/add")
    public String newTeacher(@Valid Teacher teacher, BindingResult bindingResult, Model model) {
		model.addAttribute("teacher", new Teacher());
		TeacherService.saveTeacher(teacher);
		model.addAttribute("classes", ClasseService.listAllClasses());
		model.addAttribute("schools", SchoolService.listAllSchools());
		model.addAttribute("courses", CourseService.listAllCourses());
        return "add-teacher";
    }

	// @GetMapping("teacher/edit/{id}")
	// public String showUpdateForm(@PathVariable("id") int id, Model model) {
	// 	model.addAttribute("Teacher", TeacherService.getTeacherById(id));
	// 	model.addAttribute("Classe", ClasseService.listAllClasses());
	// 	model.addAttribute("Course", CourseService.listAllCourses());
	// 	model.addAttribute("School", SchoolService.listAllSchools());
	// 	return "update-Teacher";
	// }

	// @PostMapping("teacher/update/{id}")
	// public String updateTeacher(@PathVariable("id") int id, @Valid Teacher Teacher, BindingResult result,
	// 		Model model) {
	// 	if (result.hasErrors()) {
	// 		Teacher.setId(id);
	// 		return "update-Teacher";
	// 	}

	// 	TeacherService.saveTeacher(Teacher);
	// 	model.addAttribute("teachers", TeacherService.listAllTeachers());
	// 	model.addAttribute("schools", SchoolService.listAllSchools());
	// 	model.addAttribute("course", CourseService.listAllCourses());
	// 	model.addAttribute("classe", ClasseService.listAllClasses());
	// 	return "teachers";
	// }
	// @RequestMapping("delete/{id}")
    // public String deleteTeacher(@PathVariable Integer id) {
    //     TeacherService.deleteTeacher(id);
    //     return "redirect:/teachers";
    // }

	// @RequestMapping(value = "teacher", method = RequestMethod.POST)
    // public String saveTeacher(Client teacher) {
    //     teacherService.saveTeacher(teacher);
    //     return "redirect:/teacher/" + client.getId();
	// }


	@GetMapping("teacher/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Teacher teacher = teacherRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
		model.addAttribute("teacher", teacher);
		return "update-teacher";
	}

	@PostMapping("teacher/update/{id}")
	public String updateTeacher(@PathVariable("id") long id, @Valid Teacher teacher, BindingResult result,
			Model model) {
		// if (result.hasErrors()) {
		// 	teacher.setId(id);
		// 	return "update-teacher";
		// }

		teacherRepository.save(teacher);
		model.addAttribute("teachers", teacherRepository.findAll());
		return "teachers";
	}

	@GetMapping("teacher/delete/{id}")
	public String deleteTeacher(@PathVariable("id") Integer id, Model model) {
		Teacher teacher = teacherRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
		teacherRepository.delete(teacher);
		model.addAttribute("teachers", teacherRepository.findAll());
		return "teachers";
	}


}
