package com.maxwellwehner.recipeshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
