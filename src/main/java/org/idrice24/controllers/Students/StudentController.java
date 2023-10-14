package org.idrice24.controllers.Students;

import javax.validation.Valid;

import org.idrice24.entities.Students.Student;
import org.idrice24.repositories.Students.StudentRepository;
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
@RequestMapping("/students/")
public class StudentController {

    @Autowired
	private final StudentService studentService;

    @Autowired
	private final StudentRepository studentRepository;

	private ClasseService classeService;

	@Autowired
	public StudentController(StudentService studentService, StudentRepository studentRepository, ClasseService classeService) {
		this.studentService = studentService;
		this.studentRepository = studentRepository;
		this.classeService = classeService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Student student, Model model) {
		model.addAttribute("classes", classeService.getAllClasse());
		return "add-student";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("students", studentService.listAllStudents());
		return "student";
	}

	@PostMapping("add")
	public String addStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

        Student u = studentRepository.save(student);
		long b = u.getId();
        String a = "SMS2E00" + b ;
		if(a != student.getSui()){
			String E = new String();
			student.setSui(a+E);
		}
		student.setSui(a);
		studentService.saveStudent(student);
		model.addAttribute("classes", classeService.getAllClasse());
		return "redirect:list";
	}
	@GetMapping("view/{id}")
	public String viewStudent(@PathVariable("id") long id, Model model){
		model.addAttribute("students", studentRepository.findById(id));
		return "studentview";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Student student = (studentRepository.findById(id));
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student id:" + id));
		model.addAttribute("student", student);
		model.addAttribute("classes", classeService.getAllClasse());
		return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		//model.addAttribute("sections", sectionService.listAllSections());
		model.addAttribute("classes", classeService.getAllClasse());
		return "student";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		Student student = (studentRepository.findById(id));
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		studentRepository.delete(student);
		model.addAttribute("students", studentRepository.findAll());
		return "student";
	}
}
