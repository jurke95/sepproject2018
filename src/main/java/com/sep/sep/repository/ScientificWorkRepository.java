package com.sep.sep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sep.sep.model.ScientificWork;



@Repository
public interface ScientificWorkRepository extends JpaRepository<ScientificWork,Long> {
	
	ScientificWork findOneById(Long id);
	List<ScientificWork> findAll();
	
	@Query(value="SELECT sw FROM ScientificWork sw WHERE (sw.magazine.id)=(:idm) AND (sw.edition.id)=(:ide)")
	List<ScientificWork>getWorksByMagazineAndEdition(@Param("idm")Long idm,@Param("ide")Long ide);


}
