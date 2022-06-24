package com.maxwellwehner.recipeshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.maxwellwehner.recipeshare.entity.Cookbook;
import com.maxwellwehner.recipeshare.service.CookbookService;

@Controller
public class CookbookController {

	@Autowired
	private CookbookService cookbookService;

	@GetMapping("/cookbooks")
	public String viewCookbooks(Model model) {
		model.addAttribute("listCookbooks", cookbookService.getAllCookbooks());
		return "cookbooks";
	}

	@GetMapping("/showNewCookbookForm")
	public String showNewCookbookForm(Model model) {
		Cookbook cookbook = new Cookbook();
		model.addAttribute("cookbook", cookbook);
		return "new_cookbook";
	}

	@PostMapping("/saveCookbook")
	public String saveCookbook(@ModelAttribute("cookbook") Cookbook cookbook) {
		cookbookService.saveCookbook(cookbook);
		return "redirect:/cookbooks";
	}

	@GetMapping("/deleteCookbook/{id}")
	public String deleteCookbook(@PathVariable(value = "id") long id) {
		cookbookService.deleteCookbookById(id);
		return "redirect:/cookbooks";
	}

	@GetMapping("/showCookbookUpdateForm/{id}")
	public String showCookbookUpdateForm(@PathVariable(value = "id") long id, Model model) {
		Cookbook cookbook = cookbookService.getCookbookById(id);

		model.addAttribute("cookbook", cookbook);
		return "update_cookbook";
	}

}
