package com.sep.sep.controller.dto;

public class TaskCamunda {
	
	private String name;
	private String taskid;
	
	public TaskCamunda(){
		
	}
	
	
	
	public TaskCamunda(String name, String taskid) {
		super();
		this.name = name;
		this.taskid = taskid;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	
	

}
