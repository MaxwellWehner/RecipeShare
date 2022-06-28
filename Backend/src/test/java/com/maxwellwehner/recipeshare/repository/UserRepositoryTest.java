package com.maxwellwehner.recipeshare.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.maxwellwehner.recipeshare.entity.User;

@SpringBootTest
class UserRepositoryTest {

	private User user;

	@Autowired
	UserRepository userRepo;

	@BeforeEach
	void init_findByEmailTests() {
		String email = "max@gmail.com";
		this.user = this.userRepo.findByEmail(email);
	}

	@Test
	void test_firstName() {
		assertEquals(this.user.getFirstName(), "max");
	}

	@Test
	void test_lastName() {
		assertEquals(this.user.getLastName(), "max");
	}

	@Test
	void test_password() {
		assertEquals(this.user.getPassword(), "$2a$10$jmWH3XAoFJahTvrpODzg4.Y6HIlCzBzCbGpscE.qNLZGSVy6nUI22");
	}

}
