package com.sep.sep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.ScienceArea;

@Repository
public interface ScienceAreaRepository extends JpaRepository<ScienceArea,Long> {
	
	ScienceArea findOneById(Long id);
	List<ScienceArea>findAll();
	@Query("select sa.name from ScienceArea sa")
	List<String> getAllAreasNames();

	
	@Query("select sa from ScienceArea sa where (sa.name)=(:name)")
	ScienceArea findScienceArea(@Param("name")String name);
}
