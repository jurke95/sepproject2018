package com.sep.sep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sep.sep.model.ScientificWork;



@Repository
public interface ScientificWorkRepository extends JpaRepository<ScientificWork,Long> {
	
	ScientificWork findOneById(Long id);
	List<ScientificWork> findAll();


}
