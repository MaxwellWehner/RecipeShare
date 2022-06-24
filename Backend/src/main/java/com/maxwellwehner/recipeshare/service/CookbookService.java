package com.maxwellwehner.recipeshare.service;

import java.util.Collection;

import com.maxwellwehner.recipeshare.entity.Cookbook;

public interface CookbookService {
	Collection<Cookbook> getAllCookbooks();
	void saveCookbook(Cookbook cookbook);
	void deleteCookbookById(long id);
	Cookbook getCookbookById(long id);
}
