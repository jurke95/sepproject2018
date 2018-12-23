package com.sep.sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.EditorArea;



@Repository
public interface EditorAreaRepository extends JpaRepository<EditorArea,Long> {
	
	EditorArea findOneById(Long id);
	

}