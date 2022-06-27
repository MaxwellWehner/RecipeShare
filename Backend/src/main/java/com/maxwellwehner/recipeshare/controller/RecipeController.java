package com.maxwellwehner.recipeshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.maxwellwehner.recipeshare.entity.Recipe;
import com.maxwellwehner.recipeshare.entity.User;
import com.maxwellwehner.recipeshare.repository.UserRepository;
import com.maxwellwehner.recipeshare.service.CookbookService;
import com.maxwellwehner.recipeshare.service.RecipeService;

@Controller
public class RecipeController {
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private CookbookService cookbookService;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/recipes")
	public String viewRecipes(Model model) {
		model.addAttribute("listRecipes", recipeService.getAllRecipes());
		return "recipes";
	}
	
	@GetMapping("/recipe/{id}")
	public String viewRecipe(@PathVariable(value = "id") long id, Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByEmail(email);
		model.addAttribute("recipe", recipeService.getRecipeById(id));
		model.addAttribute("cookbooks", cookbookService.getAllCookbooksForAUser(user));
		return "recipe";
	}

	@GetMapping("/showNewRecipeForm")
	public String showNewRecipeForm(Model model) {
		Recipe recipe = new Recipe();
		model.addAttribute("recipe", recipe);
		return "new_recipe";
	}

	@PostMapping("/saveRecipe")
	public String saveRecipe(@ModelAttribute("recipe") Recipe recipe) {
		recipeService.saveRecipe(recipe);
		return "redirect:/recipes";
	}

	@GetMapping("/deleteRecipe/{id}")
	public String deleteRecipe(@PathVariable(value = "id") long id) {
		recipeService.deleteRecipeById(id);
		return "redirect:/recipes";
	}

	@GetMapping("/showRecipeUpdateForm/{id}")
	public String showRecipeUpdateForm(@PathVariable(value = "id") long id, Model model) {
		Recipe recipe = recipeService.getRecipeById(id);

		model.addAttribute("recipe", recipe);
		return "update_recipe";
	}
}
