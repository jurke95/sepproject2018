package com.sep.sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
	
	Author findOneById(Long id);

}