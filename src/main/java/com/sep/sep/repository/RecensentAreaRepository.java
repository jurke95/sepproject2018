package com.sep.sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.RecensentArea;



@Repository
public interface RecensentAreaRepository extends JpaRepository<RecensentArea,Long> {
	
	RecensentArea findOneById(Long id);

}
