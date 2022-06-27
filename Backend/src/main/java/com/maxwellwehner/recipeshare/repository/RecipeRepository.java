package com.maxwellwehner.recipeshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxwellwehner.recipeshare.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
