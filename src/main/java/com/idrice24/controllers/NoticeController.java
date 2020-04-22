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

import com.idrice24.entities.Notice;
import com.idrice24.repositories.NoticeRepository;

@Controller
@RequestMapping("/notices/")
public class NoticeController {

	private final NoticeRepository NoticeRepository;

	@Autowired
	public NoticeController(NoticeRepository NoticeRepository) {
		this.NoticeRepository = NoticeRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Notice notice) {
		return "add-Notice";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("notices", NoticeRepository.findAll());
		return "notices";
	}

	@PostMapping("add")
	public String addNotice(@Valid Notice Notice, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Notice";
		}

		NoticeRepository.save(Notice);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Notice notice = NoticeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid notice Id:" + id));
		model.addAttribute("notice", notice);
		return "update-notice";
	}

	@PostMapping("update/{id}")
	public String updateNotice(@PathVariable("id") long id, @Valid Notice notice, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			notice.setId(id);
			return "update-Notice";
		}

		NoticeRepository.save(notice);
		model.addAttribute("Notices", NoticeRepository.findAll());
		return "notices";
	}

	@GetMapping("delete/{id}")
	public String deleteNotice(@PathVariable("id") long id, Model model) {
		Notice Notice = NoticeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Notice Id:" + id));
		NoticeRepository.delete(Notice);
		model.addAttribute("Notices", NoticeRepository.findAll());
		return "notices";
	}
}
