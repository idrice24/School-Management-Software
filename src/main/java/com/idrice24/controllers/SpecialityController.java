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

import com.idrice24.entities.Speciality;
import com.idrice24.repositories.SpecialityRepository;

@Controller
@RequestMapping("/specialitys/")
public class SpecialityController {

	private final SpecialityRepository specialityRepository;

	@Autowired
	public SpecialityController(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Speciality speciality) {
		return "add-speciality";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("specialitys", specialityRepository.findAll());
		return "specialitys";
	}

	@PostMapping("add")
	public String addSpeciality(@Valid Speciality speciality, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-speciality";
		}

		specialityRepository.save(speciality);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Speciality speciality = specialityRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid speciality Id:" + id));
		model.addAttribute("speciality", speciality);
		return "update-speciality";
	}

	@PostMapping("update/{id}")
	public String updateSpeciality(@PathVariable("id") long id, @Valid Speciality speciality, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			speciality.setId(id);
			return "update-speciality";
		}

		specialityRepository.save(speciality);
		model.addAttribute("specialitys", specialityRepository.findAll());
		return "specialitys";
	}

	@GetMapping("delete/{id}")
	public String deleteSpeciality(@PathVariable("id") long id, Model model) {
		Speciality speciality = specialityRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid speciality Id:" + id));
		specialityRepository.delete(speciality);
		model.addAttribute("specialitys", specialityRepository.findAll());
		return "specialitys";
	}
}
