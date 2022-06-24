package com.maxwellwehner.recipeshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxwellwehner.recipeshare.entity.Cookbook;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook, Long> {

}
