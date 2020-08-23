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

import com.idrice24.entities.Studlist;
import com.idrice24.repositories.StudlistRepository;

@Controller
@RequestMapping("/studlists/")
public class StudlistController {

	private final StudlistRepository studlistRepository;

	@Autowired
	public StudlistController(StudlistRepository studlistRepository) {
		this.studlistRepository = studlistRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Studlist studlist) {
		return "add-studlist";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("studlists", studlistRepository.findAll());
		return "studlists";
	}

	@PostMapping("add")
	public String addStudlist(@Valid Studlist studlist, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-studlist";
		}

		studlistRepository.save(studlist);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Studlist studlist = studlistRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid studlist Id:" + id));
		model.addAttribute("studlist", studlist);
		return "update-studlist";
	}

	@PostMapping("update/{id}")
	public String updateStudlist(@PathVariable("id") long id, @Valid Studlist studlist, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			studlist.setId(id);
			return "update-studlist";
		}

		studlistRepository.save(studlist);
		model.addAttribute("studlists", studlistRepository.findAll());
		return "studlist";
	}

	@GetMapping("delete/{id}")
	public String deleteStudlist(@PathVariable("id") long id, Model model) {
		Studlist studlist = studlistRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid studlist Id:" + id));
		studlistRepository.delete(studlist);
		model.addAttribute("studlists", studlistRepository.findAll());
		return "studlist";
	}
}
