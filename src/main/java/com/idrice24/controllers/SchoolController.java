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

import com.idrice24.entities.School;
import com.idrice24.repositories.SchoolRepository;

@Controller
@RequestMapping("/schools/")
public class SchoolController {

	private final SchoolRepository SchoolRepository;

	@Autowired
	public SchoolController(SchoolRepository SchoolRepository) {
		this.SchoolRepository = SchoolRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(School School) {
		return "add-School";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Schools", SchoolRepository.findAll());
		return "schools";
	}

	@PostMapping("add")
	public String addSchool(@Valid School School, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-School";
		}

		SchoolRepository.save(School);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		School School = SchoolRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid School Id:" + id));
		model.addAttribute("school", School);
		return "update-School";
	}

	@PostMapping("update/{id}")
	public String updateSchool(@PathVariable("id") long id, @Valid School School, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			School.setId(id);
			return "update-School";
		}

		SchoolRepository.save(School);
		model.addAttribute("Schools", SchoolRepository.findAll());
		return "schools";
	}

	@GetMapping("delete/{id}")
	public String deleteSchool(@PathVariable("id") long id, Model model) {
		School School = SchoolRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid School Id:" + id));
		SchoolRepository.delete(School);
		model.addAttribute("schools", SchoolRepository.findAll());
		return "schools";
	}
}
