package com.sep.sep.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.Magazine;
import com.sep.sep.repository.MagazineRepository;

@Service
public class MagazineCheckDelegate implements JavaDelegate {
	
	@Autowired
	private MagazineRepository magazineRepository;
	

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Long idm = (Long) execution.getVariable("magazinid");
		System.out.println(idm + "ovo je iz delegate");
		Magazine m = magazineRepository.findOneById(idm);
		
		
		if(m.isOpenaccess()) {
			execution.setVariable("openaccess", true);
		}
		else {
			execution.setVariable("openaccess", false);
		}

	}

}
