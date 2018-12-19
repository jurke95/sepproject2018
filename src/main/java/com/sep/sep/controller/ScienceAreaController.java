package com.sep.sep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sep.sep.response.ScienceAreaResponse;
import com.sep.sep.service.ScienceAreaService;

@RestController
@RequestMapping("/sarea")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")
public class ScienceAreaController {
	
	@Autowired
	private ScienceAreaService scienceAreaService;
	
	
	
	
	@JsonValue
	@GetMapping("/getSAreasNames")
	public List<ScienceAreaResponse> getAreasNames() {

		
		List<String> lists=scienceAreaService.getAreas();
		
		List<ScienceAreaResponse> sar=new ArrayList<ScienceAreaResponse>();
		
		for(int i=0;i<lists.size();i++){
			
			ScienceAreaResponse n=new ScienceAreaResponse(lists.get(i),lists.get(i));
			sar.add(n);
		}
		
		
		return sar;

	}

}
