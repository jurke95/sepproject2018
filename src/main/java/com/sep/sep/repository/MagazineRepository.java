package com.sep.sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Magazine;



@Repository
public interface MagazineRepository extends JpaRepository<Magazine,Long> {
	
	Magazine findOneById(Long id);

}
