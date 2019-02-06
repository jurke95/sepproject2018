package com.sep.sep.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Reader;



@Repository
public interface ReaderRepository extends JpaRepository<Reader,Long> {
	
	Reader findOneById(Long id);
	Optional<Reader> findOneByEmail(String email);
	Reader findOneByUsername(String username);

}
