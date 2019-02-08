package com.sep.sep.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Membership;




@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {
	
	Membership findOneById(Long id);
	
	@Query(value="SELECT m FROM Membership m WHERE (m.member.id)=(:id)")
	List<Membership>getMembershipsByUser(@Param("id")Long id);

	
	@Query(value="SELECT m FROM Membership m WHERE (m.member.email)=(:username) AND (m.magazine.id)=(:idm)")
	Membership getMembershipByUserAndMagazine(@Param("username")String username,@Param("idm")Long idm);

}