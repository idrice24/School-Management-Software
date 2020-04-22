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

import com.idrice24.entities.Department;
import com.idrice24.repositories.DepartmentRepository;

@Controller
@RequestMapping("/departments/")
public class DepartmentController {

	private final DepartmentRepository DepartmentRepository;

	@Autowired
	public DepartmentController(DepartmentRepository DepartmentRepository) {
		this.DepartmentRepository = DepartmentRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Department Department) {
		return "add-Department";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Departments", DepartmentRepository.findAll());
		return "departments";
	}

	@PostMapping("add")
	public String addDepartment(@Valid Department Department, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Department";
		}

		DepartmentRepository.save(Department);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Department Department = DepartmentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Department Id:" + id));
		model.addAttribute("Department", Department);
		return "update-Department";
	}

	@PostMapping("update/{id}")
	public String updateDepartment(@PathVariable("id") long id, @Valid Department Department, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			Department.setId(id);
			return "update-Department";
		}

		DepartmentRepository.save(Department);
		model.addAttribute("Departments", DepartmentRepository.findAll());
		return "departments";
	}

	@GetMapping("delete/{id}")
	public String deleteDepartment(@PathVariable("id") long id, Model model) {
		Department Department = DepartmentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Department Id:" + id));
		DepartmentRepository.delete(Department);
		model.addAttribute("Departments", DepartmentRepository.findAll());
		return "departments";
	}
}
