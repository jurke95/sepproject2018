package com.sep.sep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.Transaction;
import com.sep.sep.repository.TransactionRepository;

@Service
public class TransactionService {
	
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	
	public Transaction saveTransaction(Transaction t){
		
		
		return transactionRepository.save(t);
		
	}
	
	
	public Transaction getTransactionById(Long id){
		
		return transactionRepository.findOneById(id);
	}

}
