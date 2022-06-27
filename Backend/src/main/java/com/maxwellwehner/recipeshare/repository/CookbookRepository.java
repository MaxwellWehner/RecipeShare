package com.maxwellwehner.recipeshare.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maxwellwehner.recipeshare.entity.Cookbook;
import com.maxwellwehner.recipeshare.entity.User;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook, Long> {
	@Query("Select c From Cookbook c where userId = ?1")
	Collection<Cookbook> findAllCookbooksForUser(User user);
}
