package com.maxwellwehner.recipeshare.service;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.maxwellwehner.recipeshare.config.UserRegistrationDto;
import com.maxwellwehner.recipeshare.entity.User;

public interface UserService extends UserDetailsService {
   User findByEmail(String email);
   User save(UserRegistrationDto registration);
   Collection<User> getAllUsers();
   void deleteuserById(long id);
}
