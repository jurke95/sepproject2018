package com.sep.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.ScientificWork;
import com.sep.sep.repository.ScientificWorkRepository;

@Service
public class ScientificWorkService {
	
	@Autowired
	private ScientificWorkRepository scientificWorkRepository;
	
	
	
	
	
	
	public List <ScientificWork> getAllScientificWorks(){
		
		
		
		return scientificWorkRepository.findAll();
	}

}
