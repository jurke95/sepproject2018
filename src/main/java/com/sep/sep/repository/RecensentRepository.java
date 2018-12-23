package com.sep.sep.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Recensent;



@Repository
public interface RecensentRepository extends JpaRepository<Recensent,Long> {
	
	Recensent findOneById(Long id);
	Optional<Recensent> findOneByEmail(String email);

}
