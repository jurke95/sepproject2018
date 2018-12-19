package com.sep.sep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.EditorArea;
import com.sep.sep.repository.EditorAreaRepository;

@Service
public class EditorAreaService {
	
	
	@Autowired
	private EditorAreaRepository editorAreaRepository;
	
	
	
	
	public EditorArea saveEditorArea(EditorArea ea){
		
		
		return editorAreaRepository.save(ea);
	}

}
