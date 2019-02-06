package com.sep.sep.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.sep.model.Author;
import com.sep.sep.model.Editor;
import com.sep.sep.model.Reader;
import com.sep.sep.model.Recensent;
import com.sep.sep.model.RegUser;
import com.sep.sep.repository.AuthorRepository;
import com.sep.sep.repository.EditorAreaRepository;
import com.sep.sep.repository.EditorRepository;
import com.sep.sep.repository.ReaderRepository;
import com.sep.sep.repository.RecensentRepository;
import com.sep.sep.repository.RegUserRepository;

@Service
public class UserService {

	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private ReaderRepository readerRepository;
	
	@Autowired
	private EditorRepository editorRepository;
	
	@Autowired
	private EditorAreaRepository editorAreaRepository;
	
	
	@Autowired
	private RecensentRepository recensentRepository;
	
	
	@Autowired
	private RegUserRepository regUserRepository;
	
	
	
	public Author registrateAuthor(Author a){
		
		a.setActive(true);
		RegUser rr= new RegUser();
		 rr.setUsername(a.getUsername());
		 rr.setPassword(a.getPassword());
		 rr.setActive(true);
		 rr.setEmail(a.getEmail());
		 rr.setName(a.getName());
		 rr.setCity(a.getCity());
		 rr.setCountry(a.getCountry());
		 rr.setSurname(a.getSurname());
		 rr.setRole("AUTHOR");
		 RegUser sav=registrateRegUser(rr);
	
		
		return authorRepository.save(a);
		
	}
	
public Reader registrateReader(Reader re){
		
		re.setActive(true);
		RegUser rr= new RegUser();
		 rr.setUsername(re.getUsername());
		 rr.setPassword(re.getPassword());
		 rr.setActive(true);
		 rr.setEmail(re.getEmail());
		 rr.setName(re.getName());
		 rr.setCity(re.getCity());
		 rr.setCountry(re.getCountry());
		 rr.setSurname(re.getSurname());
		 rr.setRole("READER");
		 RegUser sav=registrateRegUser(rr);
	
		
		return readerRepository.save(re);
		
	}
	
	
 public   Editor registrateEditor(Editor e){
		
	
	 e.setActive(true);
	 
	 RegUser rr=new RegUser();
	 rr.setUsername(e.getUsername());
	 rr.setPassword(e.getPassword());
	 rr.setActive(true);
	 rr.setEmail(e.getEmail());
	 rr.setTitle(e.getTitle());
	 rr.setName(e.getName());
	 rr.setCity(e.getCity());
	 rr.setCountry(e.getCountry());
	 rr.setSurname(e.getSurname());
	 
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
   
   
   public List<String>getEditorsAreasNames(String email){

    return editorAreaRepository.findEditorAreaNames(email);
   }
   
   
   public Optional<Author> getAuthorByEmail(String email){
	   
	   return authorRepository.findOneByEmail(email);
   }
   
 public Optional<Reader> getReaderByEmail(String email){
	   
	   return readerRepository.findOneByEmail(email);
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

public Reader getReaderByUsername(String username){
	   
	   return readerRepository.findOneByUsername(username);
}
	
}
