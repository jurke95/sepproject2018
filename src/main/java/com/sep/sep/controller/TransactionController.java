package com.sep.sep.controller;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sep.sep.controller.dto.TransactionDTO;
import com.sep.sep.model.Membership;
import com.sep.sep.model.RegUser;
import com.sep.sep.model.Transaction;
import com.sep.sep.repository.MagazineRepository;
import com.sep.sep.repository.MembershipRepository;
import com.sep.sep.service.MagazineService;
import com.sep.sep.service.TransactionService;
import com.sep.sep.service.UserService;

import net.minidev.json.parser.ParseException;



@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {
	
	
	
	@Autowired
	private TransactionService tService;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private MagazineService mService;
	
	@Autowired
	private MagazineRepository mRepository;
	
	@Autowired
	private MembershipRepository memRepository;
	
	
	@PostMapping("/create")
	public String createTransaction(@RequestBody TransactionDTO t) {
		
		System.out.println("Usao u kreiranje transakcije");
		
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
        
        
        System.out.println("u sledecoj liniji cuva transakciju");
        Transaction saved=tService.saveTransaction(tr);
        System.out.println("Prosao transakciju");
        System.out.println(tr.getDescription());
       
        if(tr.getDescription().equals("Membership fee for 30 days")){
        	
        	
        	Membership mem= new Membership();
        	mem.setMagazine(mRepository.findOneByName(t.getMagazinename()));
        	Optional <RegUser> found=uService.getRegUserByEmail(t.getPayermail()); 
        	if(found.isPresent()){
        		RegUser newmember=found.get();
        		mem.setMember(newmember);
        	}
        	String timeStamp=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        	DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        	
        	Date now=null;
        	
        	try {
				now=formatter.parse(timeStamp);
				mem.setStartDate(now);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	
        	DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, +1);
			Date end = cal.getTime();
			String endString = formatter1.format(end);					
			Date endDate=null;
			try {
				endDate = formatter1.parse(endString);
				mem.setEndDate(endDate);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mem.setActive("active");
			memRepository.save(mem);
			
        	
        }
        
		return "success";
	}
	

}
