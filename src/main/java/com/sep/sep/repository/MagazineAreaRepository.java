package com.sep.sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.MagazineArea;



@Repository
public interface MagazineAreaRepository extends JpaRepository<MagazineArea,Long> {
	
	MagazineArea findOneById(Long id);

}
