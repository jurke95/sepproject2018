package com.sep.sep.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.sep.sep.model.Magazine;
import com.sep.sep.model.RegUser;
import com.sep.sep.repository.MagazineRepository;
import com.sep.sep.repository.RegUserRepository;



public class NotificationToEditorForNewScientificWorkDelegate implements JavaDelegate  {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	
	@Autowired
	private RegUserRepository userRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Long idm = (Long) execution.getVariable("magazinid");
		
		Magazine m = magazineRepository.findOneById(idm);
		
		RegUser maine = m.getMaineditor();
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(maine.getEmail());
		email.setFrom(env.getProperty("spring.mail.username"));
		
		email.setSubject("New scientific work");
		String text = "New scientific work '" + execution.getVariable("title").toString() + "' in magazine '" + m.getName()  + "' so there is need for recension.";
				
		email.setText(text);
	
		javaMailSender.send(email);
		
		
	}

}
