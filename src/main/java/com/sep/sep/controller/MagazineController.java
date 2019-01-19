package com.sep.sep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sep.sep.model.Magazine;
import com.sep.sep.service.MagazineService;

@RestController
@RequestMapping("/magazine")
@CrossOrigin(origins="http://localhost:3006",allowedHeaders="*")
public class MagazineController {

	
	@Autowired
	private MagazineService magazineService;
	
	
	
	
	@JsonValue
	@GetMapping("/getAllMagazines")
	public List<Magazine> getMagazines(){
		
		List<Magazine>listm =magazineService.getAllMagazines(); 
		
		
		return listm;
		
		
		
		
	}
	
}
