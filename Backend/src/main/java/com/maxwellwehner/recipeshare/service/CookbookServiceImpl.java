package com.maxwellwehner.recipeshare.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxwellwehner.recipeshare.entity.Cookbook;
import com.maxwellwehner.recipeshare.repository.CookbookRepository;

@Service
public class CookbookServiceImpl implements CookbookService{
	
	@Autowired
	private CookbookRepository cookbookRepository;

	@Override
	public Collection<Cookbook> getAllCookbooks() {
		return cookbookRepository.findAll();
	}

}
