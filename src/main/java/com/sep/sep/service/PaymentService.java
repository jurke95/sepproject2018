package com.sep.sep.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sep.sep.controller.dto.PaymentMembershipFDTOO;
import com.sep.sep.model.Magazine;
import com.sep.sep.model.Payment;
import com.sep.sep.model.RegUser;
import com.sep.sep.repository.MagazineRepository;
import com.sep.sep.repository.PaymentRepository;
import com.sep.sep.repository.RegUserRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@Autowired
	private RegUserRepository userRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	
	
public String createPaymentObject(Long idmag) {
		
		Magazine magazine = magazineRepository.findOneById(idmag);
		
		/*
		String useremail = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			useremail = ((UserDetails)principal).getUsername();
		} else {
			useremail = principal.toString();
		}
		
		Optional<RegUser> loginuser = userRepository.findOneByEmail(useremail);
		
		if(loginuser.get()!=null &&magazine !=null) {
		
		*/
			Payment paymentobj = new Payment();
			
			//paymentobj.setMerchant(magazine);
			//paymentobj.setCustomer(loginuser.get());	
			paymentobj.setAmount(magazine.getMembershipfee());
			paymentobj.setDescription("Membership fee for 30 days");
			paymentobj.setClientId(magazine.getClientId());
			paymentobj.setClientSecret(magazine.getClientSecret());
			paymentobj.setMagazinename(magazine.getName());
			paymentobj.setSuccessUrl("http://localhost:8083/transaction/create");
			paymentobj.setFronturl("http://localhost:3006/#/magazines");
			
			
			HttpHeaders header = new HttpHeaders();	
			HttpEntity entity = new HttpEntity(paymentobj, header);
			
			String response = restTemplate.postForObject("http://localhost:8051/objectpayment/savepaymentobject", entity, String.class);
			
			return response;
		
		
		
	}
	
	
public PaymentMembershipFDTOO getPayment(Long id) {
	
	
	Payment po = paymentRepository.findOneById(id);
	
	if(po !=null) {
		PaymentMembershipFDTOO obj = new PaymentMembershipFDTOO();
		
		obj.setIdPaymentObj(po.getId());
		obj.setIdCustomer(po.getCustomer().getId());
		obj.setNameCustomer(po.getCustomer().getName());
		obj.setSurnameCustomer(po.getCustomer().getSurname());
		obj.setEmailCustomer(po.getCustomer().getEmail());
		obj.setIdSeller(po.getMerchant().getId());
		obj.setNameSeller(po.getMerchant().getName());
		obj.setIssnumberSeller(po.getMerchant().getIssn());
		obj.setAmount(po.getAmount());
		return obj;
	}
	else {
		return null;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
}
