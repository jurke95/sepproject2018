package com.sep.sep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sep.sep.controller.dto.ScientificWorkDTO;
import com.sep.sep.model.ScientificWork;
import com.sep.sep.service.ScientificWorkService;



@RestController
@RequestMapping("/swork")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")
public class ScientificWorkController {

	
	@Autowired
	private ScientificWorkService scientificWorkService;
	
	
	@JsonValue
	@GetMapping("/getSWorks")
	public List<ScientificWork> getWorks() {

		System.out.println("USAOOO");
		List<ScientificWork> listw=scientificWorkService.getAllScientificWorks();
		return listw;

	}
	
	@JsonValue
	@GetMapping("/getWorksByIds")
	public List<ScientificWork> getWorksByIds(@RequestParam("magazineid") String magazineid,@RequestParam("editionid") String editionid) {
		
		System.out.println("POGODIO OVO BRE");

		
		Long m=new Long(Long.parseLong(magazineid));
		Long e=new Long(Long.parseLong(editionid));
		
		System.out.println(m);
		System.out.println(e);
		
		List<ScientificWork> listw=scientificWorkService.getWorksByMagazineAndEdition(m,e);
		
		
		return listw;

	}
	
	
}
