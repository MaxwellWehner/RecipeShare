package com.maxwellwehner.recipeshare.service;

import java.util.Collection;

import com.maxwellwehner.recipeshare.entity.Recipe;

public interface RecipeService {
	Collection<Recipe> getAllRecipes();
	void saveRecipe(Recipe recipe);
	void deleteRecipeById(long id);
	Recipe getRecipeById(long id);
}
