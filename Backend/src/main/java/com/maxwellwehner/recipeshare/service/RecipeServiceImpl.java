package com.maxwellwehner.recipeshare.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.maxwellwehner.recipeshare.entity.Recipe;
import com.maxwellwehner.recipeshare.entity.User;
import com.maxwellwehner.recipeshare.repository.RecipeRepository;
import com.maxwellwehner.recipeshare.repository.UserRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	@Override
	public void saveRecipe(Recipe recipe) {
		// gets the logged in user and then gets the email(getName is the email);
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByEmail(email);
		recipe.setUserId(user);
		recipeRepository.save(recipe);
	}

	@Override
	public void deleteRecipeById(long id) {
		recipeRepository.deleteById(id);
	}

	@Override
	public Recipe getRecipeById(long id) {
		Optional<Recipe> optional = recipeRepository.findById(id);
		Recipe recipe = null;

		if (optional.isPresent()) {
			recipe = optional.get();
		} else {
			throw new RuntimeException("Recipe not found for id ::" + id);
		}
		return recipe;
	}
}
