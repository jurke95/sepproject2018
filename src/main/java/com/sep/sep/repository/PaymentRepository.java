package com.sep.sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Payment;



@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
	
	Payment findOneById(Long id);

}
