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

import com.idrice24.entities.Reportlist;
import com.idrice24.repositories.ReportlistRepository;

@Controller
@RequestMapping("/reportlists/")
public class ReportlistController {

	private final ReportlistRepository reportlistRepository;

	@Autowired
	public ReportlistController(ReportlistRepository reportlistRepository) {
		this.reportlistRepository = reportlistRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Reportlist reportlist) {
		return "add-reportlist";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("reportlists", reportlistRepository.findAll());
		return "reportlists";
	}

	@PostMapping("add")
	public String addReportlist(@Valid Reportlist reportlist, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-reportlist";
		}

		reportlistRepository.save(reportlist);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Reportlist reportlist = reportlistRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid reportlist Id:" + id));
		model.addAttribute("reportlist", reportlist);
		return "update-reportlist";
	}

	@PostMapping("update/{id}")
	public String updateReportlist(@PathVariable("id") long id, @Valid Reportlist reportlist, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			reportlist.setId(id);
			return "update-reportlist";
		}

		reportlistRepository.save(reportlist);
		model.addAttribute("reportlists", reportlistRepository.findAll());
		return "reportlist";
	}

	@GetMapping("delete/{id}")
	public String deleteReportlist(@PathVariable("id") long id, Model model) {
		Reportlist reportlist = reportlistRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid reportlist Id:" + id));
		reportlistRepository.delete(reportlist);
		model.addAttribute("reportlists", reportlistRepository.findAll());
		return "reportlist";
	}
}
