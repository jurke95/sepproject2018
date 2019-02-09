package com.sep.sep.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sep.sep.model.Transaction;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
	
	Transaction findOneById(Long id);
	
	@Query(value="SELECT t FROM Transaction t WHERE (t.description)=(:name) AND (t.buyer)=(:email)")
	Transaction getPayedObject(@Param("name")String name,@Param("email")String email);
	
    
}