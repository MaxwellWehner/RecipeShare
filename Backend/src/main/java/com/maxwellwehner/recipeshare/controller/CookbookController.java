package com.maxwellwehner.recipeshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maxwellwehner.recipeshare.entity.Cookbook;
import com.maxwellwehner.recipeshare.entity.Recipe;
import com.maxwellwehner.recipeshare.service.CookbookService;
import com.maxwellwehner.recipeshare.service.RecipeService;

@Controller
public class CookbookController {
	@Autowired
	private RecipeService recipeService;

	@Autowired
	private CookbookService cookbookService;

	@GetMapping("/cookbooks")
	public String viewCookbooks(Model model) {
		model.addAttribute("listCookbooks", cookbookService.getAllCookbooks());
		return "cookbooks";
	}

	@GetMapping("/cookbook/{id}")
	public String viewCookbook(@PathVariable(value = "id") long id, Model model) {
		model.addAttribute("cookbook", cookbookService.getCookbookById(id));
		return "cookbook";
	}

	@GetMapping("/showNewCookbookForm")
	public String showNewCookbookForm(Model model) {
		Cookbook cookbook = new Cookbook();
		model.addAttribute("cookbook", cookbook);
		return "new_cookbook";
	}

	@PostMapping("/saveCookbook")
	public String saveCookbook(@ModelAttribute("cookbook") Cookbook cookbook) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(cookbook);
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

	@PostMapping("/addToCookbook/{id}")
	public String addRecipeToCookbook(@RequestParam Long cookbookId, @PathVariable(value = "id") long recipeId) {
		Cookbook cookbook = cookbookService.getCookbookById(cookbookId);
		Recipe recipe = recipeService.getRecipeById(recipeId);
		cookbookService.setCookbookRecipe(cookbook, recipe);
		return "redirect:/recipe/" + recipeId + "?success";
	}

	@GetMapping("/removeRecipeFromCookBook/info")
	public String removeRecipeFromCookBook(@RequestParam Long cookbookId, @RequestParam Long recipeId) {
		Cookbook cookbook = cookbookService.getCookbookById(cookbookId);
		Recipe recipe = recipeService.getRecipeById(recipeId);
		cookbookService.removeRecipeFromCookbook(cookbook, recipe);
		return "redirect:/cookbook/" + cookbookId;
	}

}
