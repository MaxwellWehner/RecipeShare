package com.maxwellwehner.recipeshare.service;

import java.util.Collection;

import com.maxwellwehner.recipeshare.entity.Cookbook;
import com.maxwellwehner.recipeshare.entity.Recipe;

public interface CookbookService {
	Collection<Cookbook> getAllCookbooks();
	void saveCookbook(Cookbook cookbook);
	void deleteCookbookById(long id);
	Cookbook getCookbookById(long id);
	void setCookbookRecipe(Cookbook cookbook, Recipe recipe);
}
