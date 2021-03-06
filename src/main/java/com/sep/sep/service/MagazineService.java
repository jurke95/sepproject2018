package com.sep.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.Magazine;
import com.sep.sep.model.MagazineEdition;
import com.sep.sep.repository.MagazineEditionRepository;
import com.sep.sep.repository.MagazineRepository;

@Service
public class MagazineService {
	
	
	
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	
	@Autowired
	private MagazineEditionRepository magazineEditionRepository;
	
	
	public List<Magazine> getAllMagazines(){
		
		
		
		return magazineRepository.findAll();
	}
	
	
	public List<MagazineEdition>findEditions(Long id){
		
		return magazineEditionRepository.getEditionsByMagazine(id);
		
	}

}
