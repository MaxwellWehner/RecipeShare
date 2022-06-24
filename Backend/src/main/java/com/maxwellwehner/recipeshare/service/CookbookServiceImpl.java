package com.maxwellwehner.recipeshare.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.maxwellwehner.recipeshare.entity.Cookbook;
import com.maxwellwehner.recipeshare.entity.User;
import com.maxwellwehner.recipeshare.repository.CookbookRepository;
import com.maxwellwehner.recipeshare.repository.UserRepository;

@Service
public class CookbookServiceImpl implements CookbookService {

	@Autowired
	private CookbookRepository cookbookRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<Cookbook> getAllCookbooks() {
		System.out.println(cookbookRepository.findAll());
		return cookbookRepository.findAll();
	}

	@Override
	public void saveCookbook(Cookbook cookbook) {
		// gets the logged in user the makes it a string and parses out the email
		String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().split("=|,")[1];
		User user = userRepository.findByEmail(email);
		cookbook.setUserId(user);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(cookbook);
		cookbookRepository.save(cookbook);
	}

	@Override
	public void deleteCookbookById(long id) {
		cookbookRepository.deleteById(id);
	}

	@Override
	public Cookbook getCookbookById(long id) {
		Optional<Cookbook> optional = cookbookRepository.findById(id);
		Cookbook cookbook = null;

		if (optional.isPresent()) {
			cookbook = optional.get();
		} else {
			throw new RuntimeException("Cookbook not found for id ::" + id);
		}
		return cookbook;
	}

}
