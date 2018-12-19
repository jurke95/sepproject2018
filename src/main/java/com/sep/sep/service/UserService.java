package com.sep.sep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.Author;
import com.sep.sep.model.Editor;
import com.sep.sep.model.Recensent;
import com.sep.sep.repository.AuthorRepository;
import com.sep.sep.repository.EditorRepository;
import com.sep.sep.repository.RecensentRepository;

@Service
public class UserService {

	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private EditorRepository editorRepository;
	
	@Autowired
	private RecensentRepository recensentRepository;
	
	
	
	
	
	public Author registrateAuthor(Author a){
		
	
		
		return authorRepository.save(a);
		
	}
	
	
 public   Editor registrateEditor(Editor e){
		
	
		
		return editorRepository.save(e);
		
	}
    
    
    
   public  Recensent registrateRecensent(Recensent r){
		
	
		
		return recensentRepository.save(r);
		
	}
    
    
    
	
}
