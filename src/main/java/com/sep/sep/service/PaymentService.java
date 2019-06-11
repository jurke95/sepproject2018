package com.sep.sep.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sep.sep.controller.dto.PaymentDTO;
import com.sep.sep.controller.dto.PaymentMembershipFDTOO;
import com.sep.sep.model.Magazine;
import com.sep.sep.model.MagazineEdition;
import com.sep.sep.model.Payment;
import com.sep.sep.model.RegUser;
import com.sep.sep.model.ScientificWork;
import com.sep.sep.repository.MagazineEditionRepository;
import com.sep.sep.repository.MagazineRepository;
import com.sep.sep.repository.PaymentRepository;
import com.sep.sep.repository.RegUserRepository;
import com.sep.sep.repository.ScientificWorkRepository;
import com.sep.sep.security.TokenProvider;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	
	@Autowired
	private RegUserRepository userRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Autowired
	private RestTemplate restTemplate;
   
	@Autowired
	private MagazineEditionRepository magazineEditionRepository;
	
	@Autowired
	private ScientificWorkRepository swRepository;
	
	
public String createPaymentObject(PaymentDTO dto,String j) {
		
		Magazine magazine = magazineRepository.findOneById(Long.parseLong(dto.getMagazineid()));
		
		
		String usern=tokenProvider.getUsernameFromToken(j);
		
		
			Payment paymentobj = new Payment();
			
			
			if(dto.getEditionid().equals("0") && dto.getArticleid().equals("0")){
			paymentobj.setAmount(magazine.getMembershipfee());
			paymentobj.setDescription("Membership fee for 30 days");
			}else if(dto.getArticleid().equals("0")){
				MagazineEdition me=magazineEditionRepository.findOneById(Long.parseLong(dto.getEditionid()));
				paymentobj.setAmount(me.getPrice());
				paymentobj.setDescription(me.getName());
				
			}else if(dto.getEditionid().equals("0")){
				double x=1;
				ScientificWork sw=swRepository.getOne(Long.parseLong(dto.getArticleid()));
				paymentobj.setAmount(x);
				paymentobj.setDescription(sw.getName());
			}
			paymentobj.setClientId(magazine.getClientId());
			paymentobj.setClientSecret(magazine.getClientSecret());
			paymentobj.setBitcointoken(magazine.getBitcointoken());
			paymentobj.setMerchantid(magazine.getMerchant_id());
			paymentobj.setMerchantpassword(magazine.getMerchant_password());
			paymentobj.setMagazinename(magazine.getName());
			paymentobj.setPayermail(usern);
			paymentobj.setTitle("pay");
			
			
			
			
			InetAddress ip;
	        String hostname;
	        try {
	            ip = InetAddress.getLocalHost();
	            hostname = ip.getHostName();
	            String s =ip.toString();
	            String s1 = s.split("/")[1];
	            System.out.println("EVOOOO " + s1);
	            paymentobj.setSuccessUrl("http://" + s1 + ":8083/transaction/create");
	            System.out.println("Your current IP address : " + ip);
	            System.out.println("Your current Hostname : " + hostname);
	 
	        } catch (UnknownHostException e) {
	 
	            e.printStackTrace();
	        }
			
			
			paymentobj.setFronturl("http://localhost:3006/#/magazines"); 
			
			
			HttpHeaders header = new HttpHeaders();	
			HttpEntity entity = new HttpEntity(paymentobj, header);
			
			String response = restTemplate.postForObject("http://192.168.43.174:8051/objectpayment/savepaymentobject", entity, String.class); // URL CHANGE
			
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
