package com.sep.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sep.sep.model.ScienceArea;

import com.sep.sep.repository.ScienceAreaRepository;

@Service
public class ScienceAreaService {
	
	
	@Autowired
	private ScienceAreaRepository scienceAreaRepository;
	
	
	public List<ScienceArea>getAllAreas(){
		
		
		return scienceAreaRepository.findAll();
	}

	public List<String>getAreas(){
		
		return scienceAreaRepository.getAllAreasNames();
	}
	
	
	public ScienceArea findScienceAreaByName(String name){
		
		return scienceAreaRepository.findScienceArea(name);
		
	}
	
	public ScienceArea saveScienceArea(ScienceArea sa){
		
		return scienceAreaRepository.save(sa);
	}
	
	
}
