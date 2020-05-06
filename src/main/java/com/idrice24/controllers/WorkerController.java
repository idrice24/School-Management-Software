package com.idrice24.controllers;

 import javax.validation.Valid;
// import com.google.api.translate;
// import com.google.api.translate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idrice24.entities.Worker;
import com.idrice24.repositories.WorkerRepository;

@Controller
@RequestMapping("/workers/")
public class WorkerController {

	private final WorkerRepository workerRepository;

	@Autowired
	public WorkerController(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Worker worker) {
		return "add-worker";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("workers", workerRepository.findAll());
		return "workers";
	}

	@PostMapping("add")
	public String addWorker(@Valid Worker worker, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-worker";
		}

		workerRepository.save(worker);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Worker worker = workerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid worker Id:" + id));
		model.addAttribute("worker", worker);
		return "update-worker";
	}

	@PostMapping("update/{id}")
	public String updateWorker(@PathVariable("id") long id, @Valid Worker worker, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			worker.setId(id);
			return "update-worker";
		}

		workerRepository.save(worker);
		model.addAttribute("workers", workerRepository.findAll());
		return "workers";
	}

	@GetMapping("delete/{id}")
	public String deleteWorker(@PathVariable("id") long id, Model model) {
		Worker worker = workerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid worker Id:" + id));
		workerRepository.delete(worker);
		model.addAttribute("workers", workerRepository.findAll());
		return "workers";
	}
}
