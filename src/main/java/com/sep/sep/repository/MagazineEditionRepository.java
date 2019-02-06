package com.sep.sep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.MagazineEdition;



@Repository
public interface MagazineEditionRepository extends JpaRepository<MagazineEdition,Long> {
	
	MagazineEdition findOneById(Long id);
	
	@Query(value="SELECT me FROM MagazineEdition me WHERE (me.magazine.id)=(:id)")
	List<MagazineEdition>getEditionsByMagazine(@Param("id")Long id);

}