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

import com.idrice24.entities.Student;
import com.idrice24.services.StudentService;
import com.idrice24.repositories.StudentRepository;

import com.idrice24.entities.School;
import com.idrice24.services.SchoolService;

import com.idrice24.entities.Course;
import com.idrice24.services.CourseService;

import com.idrice24.entities.Classe;
import com.idrice24.services.ClasseService;

@Controller
public class StudentController {

	private final StudentService StudentService;
	private CourseService CourseService;
	private ClasseService ClasseService;
	private SchoolService SchoolService;

	private StudentRepository studentRepository;

	@Autowired
	public StudentController(StudentService StudentService) {
		this.StudentService = StudentService;
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
	public void StudentController(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}


	@RequestMapping(value = "/students", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("students", StudentService.listAllStudents());
        System.out.println("Returning students:");
        return "students";
    }
	@RequestMapping("student/view/{id}")
    public String showStudent(@PathVariable Integer id, Model model) {
        model.addAttribute("student", StudentService.getStudentById(id));
        return "studentshow";
    }

	@GetMapping("student/list")
	public String showTeachlistsForm(Model model) {
		model.addAttribute("students", StudentService.listAllStudents());
		return "studentview";
	}


    @RequestMapping("student/add")
    public String newStudent(@Valid Student student, BindingResult bindingResult, Model model) {
		model.addAttribute("student", new Student());
		StudentService.saveStudent(student);
		model.addAttribute("classes", ClasseService.listAllClasses());
		model.addAttribute("schools", SchoolService.listAllSchools());
		model.addAttribute("courses", CourseService.listAllCourses());
        return "add-student";
    }

	// @GetMapping("student/edit/{id}")
	// public String showUpdateForm(@PathVariable("id") int id, Model model) {
	// 	model.addAttribute("student", studentService.getstudentById(id));
	// 	model.addAttribute("Classe", ClasseService.listAllClasses());
	// 	model.addAttribute("Course", CourseService.listAllCourses());
	// 	model.addAttribute("School", SchoolService.listAllSchools());
	// 	return "update-student";
	// }

	// @PostMapping("student/update/{id}")
	// public String updatestudent(@PathVariable("id") int id, @Valid student student, BindingResult result,
	// 		Model model) {
	// 	if (result.hasErrors()) {
	// 		student.setId(id);
	// 		return "update-student";
	// 	}

	// 	studentService.savestudent(student);
	// 	model.addAttribute("students", studentService.listAllstudents());
	// 	model.addAttribute("schools", SchoolService.listAllSchools());
	// 	model.addAttribute("course", CourseService.listAllCourses());
	// 	model.addAttribute("classe", ClasseService.listAllClasses());
	// 	return "students";
	// }
	// @RequestMapping("delete/{id}")
    // public String deletestudent(@PathVariable Integer id) {
    //     studentService.deletestudent(id);
    //     return "redirect:/students";
    // }

	// @RequestMapping(value = "student", method = RequestMethod.POST)
    // public String savestudent(Client student) {
    //     studentService.savestudent(student);
    //     return "redirect:/student/" + client.getId();
	// }


	@GetMapping("student/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "update-student";
	}

	@PostMapping("student/update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
			Model model) {
		// if (result.hasErrors()) {
		// 	student.setId(id);
		// 	return "update-student";
		// }

		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		return "students";
	}

	@GetMapping("student/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id, Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		studentRepository.delete(student);
		model.addAttribute("students", studentRepository.findAll());
		return "students";
	}


}
