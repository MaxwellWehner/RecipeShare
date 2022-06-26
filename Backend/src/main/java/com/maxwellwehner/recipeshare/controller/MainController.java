package com.maxwellwehner.recipeshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.maxwellwehner.recipeshare.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	   private UserService userService;

	@GetMapping("/")
	public String root() {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "admin";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value = "id") long id) {
		userService.deleteuserById(id);
		return "redirect:/admin";
	}

}
