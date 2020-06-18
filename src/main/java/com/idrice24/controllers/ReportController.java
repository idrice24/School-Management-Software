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

import com.idrice24.entities.Report;
import com.idrice24.repositories.ReportRepository;

@Controller
@RequestMapping("/reports/")
public class ReportController {

	private final ReportRepository reportRepository;

	@Autowired
	public ReportController(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Report report) {
		return "add-report";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("reports", reportRepository.findAll());
		return "reports";
	}

	@PostMapping("add")
	public String addReport(@Valid Report report, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-report";
		}

		reportRepository.save(report);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Report report = reportRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid report Id:" + id));
		model.addAttribute("report", report);
		return "update-report";
	}

	@PostMapping("update/{id}")
	public String updateReport(@PathVariable("id") long id, @Valid Report report, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			report.setId(id);
			return "update-report";
		}

		reportRepository.save(report);
		model.addAttribute("reports", reportRepository.findAll());
		return "reports";
	}

	@GetMapping("delete/{id}")
	public String deleteReport(@PathVariable("id") long id, Model model) {
		Report report = reportRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid report Id:" + id));
		reportRepository.delete(report);
		model.addAttribute("reports", reportRepository.findAll());
		return "reports";
	}
}
