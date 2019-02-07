package com.sep.sep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sep.sep.controller.dto.PaymentMembershipFDTOO;
import com.sep.sep.service.PaymentService;

@RestController
@RequestMapping("/paymentobj")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/create/{id}")
	public String createPayment(@PathVariable Long id) {
		
		
		String res = paymentService.createPaymentObject(id);
		
	
		return res;
		
	}
	
	
	@GetMapping("/getPaymentObj/{id}")
	public ResponseEntity<PaymentMembershipFDTOO> getPaymentObject(@PathVariable Long id){
		
		System.out.println(id  + " ovo je id placanjeaaa");
		
		PaymentMembershipFDTOO obj = paymentService.getPayment(id);
		
		if(obj!=null) {
			return new ResponseEntity<>(obj, HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
