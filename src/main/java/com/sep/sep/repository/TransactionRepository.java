package com.sep.sep.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Transaction;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
	
	Transaction findOneById(Long id);
	
    
}