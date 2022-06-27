package com.maxwellwehner.recipeshare.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RecipeTest {
	Recipe r;

	@BeforeEach
	void init() {
		r = new Recipe();
	}

	@Test
	void testTitleGetterAndSetter() {
		r.setTitle("test Title");
		assertEquals("test Title", r.getTitle());
	}

	@ParameterizedTest
	@ValueSource(strings = { "desc1", "desc2", "desc3" })
	void testDescriptionGetterAndSetters(String desc) {
		r.setDescription(desc);
		assertEquals(desc, r.getDescription());
	}

}
