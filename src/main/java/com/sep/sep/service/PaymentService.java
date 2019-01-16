package com.sep.sep.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

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

	
	
public Long createPaymentObject(Long idm) {
		
		Magazine magazine = magazineRepository.findOneById(idm);
		
		
		String useremail = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			useremail = ((UserDetails)principal).getUsername();
		} else {
			useremail = principal.toString();
		}
		
		Optional<RegUser> loginuser = userRepository.findOneByEmail(useremail);
		
		if(loginuser.get()!=null &&magazine !=null) {
			Payment paymentobj = new Payment();
			
			paymentobj.setMerchant(magazine);
			paymentobj.setCustomer(loginuser.get());	
			paymentobj.setAmount(1);
			paymentobj.setTitle("Payment of membership fee");
			Payment po =  paymentRepository.save(paymentobj);
			return po.getId();
		}

		return null;
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
