package com.sep.sep.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.Author;
import com.sep.sep.model.Editor;
import com.sep.sep.model.Recensent;
import com.sep.sep.model.RegUser;
import com.sep.sep.repository.AuthorRepository;
import com.sep.sep.repository.EditorRepository;
import com.sep.sep.repository.RecensentRepository;
import com.sep.sep.repository.RegUserRepository;

@Service
public class UserService {

	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private EditorRepository editorRepository;
	
	@Autowired
	private RecensentRepository recensentRepository;
	
	
	@Autowired
	private RegUserRepository regUserRepository;
	
	
	
	public Author registrateAuthor(Author a){
		
	
		
		return authorRepository.save(a);
		
	}
	
	
 public   Editor registrateEditor(Editor e){
		
	
	 e.setActive(true);
	 
	 RegUser rr=new RegUser();
	 rr.setUsername(e.getUsername());
	 rr.setPassword(e.getPassword());
	 rr.setActive(true);
	 rr.setEmail(e.getEmail());
	 RegUser sav=registrateRegUser(rr);
		
		return editorRepository.save(e);
		
	}
    
    
    
   public  Recensent registrateRecensent(Recensent r){
		
	
		
		return recensentRepository.save(r);
		
	}
    
   public  RegUser registrateRegUser(RegUser ru){
		
		
		
		return regUserRepository.save(ru);
		
	}
   
   public  Optional<RegUser> getRegUserByEmail(String email){
		
		
		
 		return regUserRepository.findOneByEmail(email);
 		
 	}
   
   
   public Optional<Author> getAuthorByEmail(String email){
	   
	   return authorRepository.findOneByEmail(email);
   }
    
   
   public Optional<Editor> getEditorByEmail(String email){
	   
	   return editorRepository.findOneByEmail(email);
   }
 
   public Optional<Recensent> getRecensentByEmail(String email){
	   
	   return recensentRepository.findOneByEmail(email);
 }
    
public Recensent getRecensentByUsername(String username){
	   
	   return recensentRepository.findOneByUsername(username);
 }
   

public Editor getEditorByUsername(String username){
	   
	   return editorRepository.findOneByUsername(username);
}

public Author getAuthorByUsername(String username){
	   
	   return authorRepository.findOneByUsername(username);
}
	
}
