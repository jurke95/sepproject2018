package com.sep.sep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sep.sep.controller.dto.ResponseDTO;
import com.sep.sep.model.Magazine;
import com.sep.sep.model.MagazineEdition;
import com.sep.sep.repository.MagazineRepository;
import com.sep.sep.service.MagazineService;



@RestController
@RequestMapping("/magazine")
@CrossOrigin(origins="http://localhost:3006",allowedHeaders="*")
public class MagazineController {

	
	@Autowired
	private MagazineService magazineService;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	
	@JsonValue
	@GetMapping("/getAllMagazines")
	public List<Magazine> getMagazines(){
		
		List<Magazine>listm =magazineService.getAllMagazines(); 
		
		
		return listm;
		
		
		
		
	}
	
	
	@JsonValue
	@GetMapping("/getMagazineById/{id}")
	public Magazine getMagazineById(@PathVariable Long id){
		
		Magazine m=magazineRepository.findOneById(id);
		
		
		return m;
		
		
		
		
	}
	
	@JsonValue
	@GetMapping("getEditionsForMagazine/{id}")
	public List<MagazineEdition> getEditions(@PathVariable Long id){
		
		List<MagazineEdition>liste = magazineService.findEditions(id);
		return liste;
	}
	
	@GetMapping("/startProcess/{idm}")
	public ResponseEntity<ResponseDTO> startProcess(@PathVariable Long idm) {
		System.out.println("usao");
		
		Map<String, Object> variables = new HashMap<>();
		
		String useremail = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			useremail = ((UserDetails)principal).getUsername();
		} else {
			useremail = principal.toString();
		}
		System.out.println(idm);
		Magazine m = magazineRepository.findOneById(idm);
		
		variables.put("maineditor", m.getMaineditor().getEmail());
		variables.put("magazinid", idm);
		variables.put("authoremail", useremail);

		ProcessInstance pi =runtimeService.startProcessInstanceByKey("Process_1", variables);
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).list().get(0);

		
		if(taskService.createTaskQuery().processInstanceId(pi.getId()).list().size()!=0) {
			
			return new ResponseEntity<>(new ResponseDTO("Successfully",task.getId()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new ResponseDTO("Unsuccessfully",""),HttpStatus.OK);
		}
		
	
		
		
	}
	
}
