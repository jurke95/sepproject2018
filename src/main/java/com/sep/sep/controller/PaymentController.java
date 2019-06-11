package com.sep.sep.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sep.sep.controller.dto.PaymentDTO;
import com.sep.sep.controller.dto.PaymentMembershipFDTOO;
import com.sep.sep.controller.response.CodeResponse;
import com.sep.sep.service.PaymentService;

@RestController
@RequestMapping("/paymentobj")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/create")
	public CodeResponse createPayment(@RequestBody PaymentDTO pdto,HttpServletRequest request) {
		
		String jw=request.getHeader("Authorization-Token");
		
		String res = paymentService.createPaymentObject(pdto,jw);
	
		
	  
		 return new CodeResponse(res);
		
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
