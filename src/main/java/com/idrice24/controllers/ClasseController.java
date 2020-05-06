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

import com.idrice24.entities.Classe;
import com.idrice24.repositories.ClasseRepository;

@Controller
@RequestMapping("/classes/")
public class ClasseController {

	private final ClasseRepository ClasseRepository;

	@Autowired
	public ClasseController(ClasseRepository ClasseRepository) {
		this.ClasseRepository = ClasseRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Classe Classe) {
		return "add-Classe";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("classes", ClasseRepository.findAll());
		return "classes";
	}

	@PostMapping("add")
	public String addClasse(@Valid Classe Classe, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Classe";
		}

		ClasseRepository.save(Classe);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Classe Classe = ClasseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Classe Id:" + id));
		model.addAttribute("classe", Classe);
		return "update-Classe";
	}

	@PostMapping("update/{id}")
	public String updateClasse(@PathVariable("id") long id, @Valid Classe Classe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			//Classe.setId(id);
			return "update-Classe";
		}

		ClasseRepository.save(Classe);
		model.addAttribute("classes", ClasseRepository.findAll());
		return "classes";
	}

	@GetMapping("delete/{id}")
	public String deleteClasse(@PathVariable("id") long id, Model model) {
		Classe Classe = ClasseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Classe Id:" + id));
		ClasseRepository.delete(Classe);
		model.addAttribute("classes", ClasseRepository.findAll());
		return "classes";
	}
}
