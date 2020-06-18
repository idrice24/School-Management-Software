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

import com.idrice24.entities.Schfee;
import com.idrice24.repositories.SchfeeRepository;
import com.idrice24.services.SchfeeService;

@Controller
@RequestMapping("/schfees/")
public class SchfeeController {

	private final SchfeeRepository schfeeRepository;


	@Autowired
	public SchfeeController(SchfeeRepository schfeeRepository) {
		this.schfeeRepository = schfeeRepository;
	}

	@GetMapping("schfee")
	public String showSignUpForm(Schfee schfee) {
		return "add-schfee";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("schfees", schfeeRepository.findAll());
		return "schfees";
	}

	@PostMapping("add")
	public String addSchfee(@Valid Schfee schfee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-schfee";
		}

		schfeeRepository.save(schfee);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Schfee schfee = schfeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid schfee Id:" + id));
		model.addAttribute("schfee", schfee);
		return "update-schfee";
	}

	@PostMapping("update/{id}")
	public String updateSchfee(@PathVariable("id") long id, @Valid Schfee schfee, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			schfee.setId(id);
			return "update-schfee";
		}

		schfeeRepository.save(schfee);
		model.addAttribute("schfees", schfeeRepository.findAll());
		return "schfees";
	}

	@GetMapping("delete/{id}")
	public String deleteSchfee(@PathVariable("id") long id, Model model) {
		Schfee schfee = schfeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid schfee Id:" + id));
		schfeeRepository.delete(schfee);
		model.addAttribute("schfees", schfeeRepository.findAll());
		return "schfees";
	}
	    @RequestMapping("schfee/{id}")
    public String showSchfee(@PathVariable long id, Model model) {
        model.addAttribute("schfee", schfeeRepository.findById(id));
        return "schfeeshow";
    }
}
