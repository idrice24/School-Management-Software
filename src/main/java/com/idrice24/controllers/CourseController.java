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

import com.idrice24.entities.Course;
import com.idrice24.repositories.CourseRepository;

@Controller
@RequestMapping("/courses/")
public class CourseController {

	private final CourseRepository CourseRepository;

	@Autowired
	public CourseController(CourseRepository CourseRepository) {
		this.CourseRepository = CourseRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Course Course) {
		return "add-Course";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("courses", CourseRepository.findAll());
		return "courses";
	}

	@PostMapping("add")
	public String addCourse(@Valid Course Course, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Course";
		}

		CourseRepository.save(Course);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Course Course = CourseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Course Id:" + id));
		model.addAttribute("course", Course);
		return "update-Course";
	}

	@PostMapping("update/{id}")
	public String updateCourse(@PathVariable("id") long id, @Valid Course Course, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			Course.setId(id);
			return "update-Course";
		}

		CourseRepository.save(Course);
		model.addAttribute("courses", CourseRepository.findAll());
		return "courses";
	}

	@GetMapping("delete/{id}")
	public String deleteCourse(@PathVariable("id") long id, Model model) {
		Course Course = CourseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Course Id:" + id));
		CourseRepository.delete(Course);
		model.addAttribute("courses", CourseRepository.findAll());
		return "courses";
	}
}
