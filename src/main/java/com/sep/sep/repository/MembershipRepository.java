package com.sep.sep.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Membership;



@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {
	
	Membership findOneById(Long id);
	

}