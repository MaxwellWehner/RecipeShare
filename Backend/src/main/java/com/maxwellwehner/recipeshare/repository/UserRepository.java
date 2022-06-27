package com.maxwellwehner.recipeshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maxwellwehner.recipeshare.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("Select u from User u where email = ?1")
	User findByEmail(String email);
}
