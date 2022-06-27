package com.maxwellwehner.recipeshare.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.maxwellwehner.recipeshare.entity.Recipe;

class RecipeServiceImplTest {
	RecipeService rs;

	@BeforeEach
	void init() {
		rs = new RecipeServiceImpl();

	}

	@Nested
	class ValidateGetRecipeById {
		@Test
		void testTitle() {
			Recipe actual = rs.getRecipeById(50);
			assertEquals(actual.getTitle(), "Chocolate Cake Updated");
		}

		@Test
		void testDescription() {
			Recipe actual = rs.getRecipeById(50);
			assertEquals(actual.getTitle(),
					"The Best Chocolate Cake Recipe – A one bowl chocolate cake recipe that is quick, easy, and delicious! Updated with gluten-free, dairy-free, and egg-free options!");
		}

	}

}
