package com.sep.sep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.RecensentArea;
import com.sep.sep.repository.RecensentAreaRepository;


@Service
public class RecensentAreaService {
	
	
	@Autowired
	private RecensentAreaRepository recensentAreaRepository;
	
	
	
	
	public RecensentArea saveRecensentArea(RecensentArea ea){
		
		
		return recensentAreaRepository.save(ea);
	}

}