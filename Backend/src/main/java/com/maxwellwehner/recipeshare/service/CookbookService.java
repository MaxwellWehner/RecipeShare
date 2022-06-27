package com.maxwellwehner.recipeshare.service;

import java.util.Collection;

import com.maxwellwehner.recipeshare.entity.Cookbook;
import com.maxwellwehner.recipeshare.entity.Recipe;
import com.maxwellwehner.recipeshare.entity.User;

public interface CookbookService {
	Collection<Cookbook> getAllCookbooks();
	Collection<Cookbook> getAllCookbooksForAUser(User user);
	void saveCookbook(Cookbook cookbook);
	void deleteCookbookById(long id);
	Cookbook getCookbookById(long id);
	void setCookbookRecipe(Cookbook cookbook, Recipe recipe);
	void removeRecipeFromCookbook(Cookbook cookbook, Recipe recipe);
}
