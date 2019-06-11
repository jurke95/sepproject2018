package com.sep.sep.controller;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sep.sep.controller.dto.ResponseDTO;
import com.sep.sep.controller.dto.TaskCamunda;





@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins="http://localhost:3006",allowedHeaders="*")
public class TasksController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	
	@GetMapping("/myTasks")
	public ResponseEntity<ArrayList<TaskCamunda>> myTasks() {
		
		String useremail = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			useremail = ((UserDetails)principal).getUsername();
		} else {
			useremail = principal.toString();
		}
		
		System.out.println(useremail);
		
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(useremail).list();
		ArrayList<TaskCamunda> retlist = new ArrayList<>();
		for(Task t : tasks) {
			retlist.add(new TaskCamunda(t.getName(), t.getId()));
		}
		
		return new ResponseEntity<>(retlist,HttpStatus.OK);
		
	}
	
	@GetMapping("/goToTask/{taskid}")
	public ResponseEntity<ResponseDTO> goToTask(@PathVariable String taskid) {
		
		List<Task> list = taskService.createTaskQuery().list();
		ResponseDTO ret = new ResponseDTO();
		for(Task t : list) {
			if(t.getId().equals(taskid)) {
				
				ret.setDotaskpath(onPage(t.getName()));
				ret.setStatus("success");
				ret.setTaksid(t.getId());
				break;
			}
		}
		return new ResponseEntity<>(ret, HttpStatus.OK);
		
	}
	
	private String onPage(String name) {
		switch(name){
			case "Enter scientific work information": 
				return "createArticle";
			
		}
		return "stay";
	}
	

}
