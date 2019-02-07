package com.sep.sep.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sep.sep.controller.dto.TransactionDTO;
import com.sep.sep.model.Transaction;
import com.sep.sep.service.TransactionService;



@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {
	
	
	
	@Autowired
	private TransactionService tService;
	
	
	
	
	
	
	@PostMapping("/create")
	public String createTransaction(@RequestBody TransactionDTO t) {
		
		
		
		Transaction tr= new Transaction();
		tr.setPaymentcode(t.getCode());
		tr.setAmount(t.getAmount());
		tr.setBuyer(t.getPayermail());
		tr.setPaymentid(t.getPaymentid());
		tr.setCurrency(t.getCurrency());
		tr.setDescription(t.getDescription());
        tr.setMerchant(t.getMerchantmail());
        tr.setTypepayment(t.getType());
        tr.setDatetime(t.getDatetime());
        tr.setMagazinename(t.getMagazinename());
        tr.setVerified("Paid");
        
        
        
        Transaction saved=tService.saveTransaction(tr);
		return "success";
	}
	

}
