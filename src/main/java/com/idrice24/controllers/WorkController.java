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

import com.idrice24.entities.Work;
import com.idrice24.repositories.WorkRepository;

@Controller
@RequestMapping("/works/")
public class WorkController {

	private final WorkRepository workRepository;

	@Autowired
	public WorkController(WorkRepository workRepository) {
		this.workRepository = workRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Work work) {
		return "add-work";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("works", workRepository.findAll());
		return "works";
	}

	@PostMapping("add")
	public String addWork(@Valid Work work, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-work";
		}

		workRepository.save(work);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Work work = workRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid work Id:" + id));
		model.addAttribute("work", work);
		return "update-work";
	}

	@PostMapping("update/{id}")
	public String updateWork(@PathVariable("id") long id, @Valid Work work, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			work.setId(id);
			return "update-work";
		}

		workRepository.save(work);
		model.addAttribute("works", workRepository.findAll());
		return "works";
	}

	@GetMapping("delete/{id}")
	public String deleteWork(@PathVariable("id") long id, Model model) {
		Work work = workRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid work Id:" + id));
		workRepository.delete(work);
		model.addAttribute("works", workRepository.findAll());
		return "works";
	}
}
