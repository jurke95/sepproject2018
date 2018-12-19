package com.sep.sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Recensent;



@Repository
public interface RecensentRepository extends JpaRepository<Recensent,Long> {
	
	Recensent findOneById(Long id);

}
