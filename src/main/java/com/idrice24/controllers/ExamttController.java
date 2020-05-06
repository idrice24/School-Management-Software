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

import com.idrice24.entities.Examtt;
import com.idrice24.repositories.ExamttRepository;

@Controller
@RequestMapping("/examtts/")
public class ExamttController {

	private final ExamttRepository ExamttRepository;

	@Autowired
	public ExamttController(ExamttRepository ExamttRepository) {
		this.ExamttRepository = ExamttRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Examtt Examtt) {
		return "add-Examtt";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("examtts", ExamttRepository.findAll());
		return "examtts";
	}

	@PostMapping("add")
	public String addExamtt(@Valid Examtt Examtt, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Examtt";
		}

		ExamttRepository.save(Examtt);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Examtt Examtt = ExamttRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Examtt Id:" + id));
		model.addAttribute("examtt", Examtt);
		return "update-Examtt";
	}

	@PostMapping("update/{id}")
	public String updateExamtt(@PathVariable("id") long id, @Valid Examtt Examtt, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			Examtt.setId(id);
			return "update-Examtt";
		}

		ExamttRepository.save(Examtt);
		model.addAttribute("examtts", ExamttRepository.findAll());
		return "examtts";
	}

	@GetMapping("delete/{id}")
	public String deleteExamtt(@PathVariable("id") long id, Model model) {
		Examtt Examtt = ExamttRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Examtt Id:" + id));
		ExamttRepository.delete(Examtt);
		model.addAttribute("examtts", ExamttRepository.findAll());
		return "examtts";
	}
}
