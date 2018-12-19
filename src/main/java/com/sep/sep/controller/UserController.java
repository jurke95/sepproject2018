package com.sep.sep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sep.sep.controller.dto.UserRegistrationDTO;
import com.sep.sep.model.Author;
import com.sep.sep.model.Editor;
import com.sep.sep.model.EditorArea;
import com.sep.sep.model.Recensent;
import com.sep.sep.model.RecensentArea;
import com.sep.sep.model.ScienceArea;
import com.sep.sep.response.MessageResponse;
import com.sep.sep.service.EditorAreaService;
import com.sep.sep.service.RecensentAreaService;
import com.sep.sep.service.ScienceAreaService;
import com.sep.sep.service.UserService;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ScienceAreaService scienceAreaService;
	
	
	@Autowired
	private EditorAreaService editoreAreaService;
	
	@Autowired
	private RecensentAreaService recensentAreaService;
	
	
	@PostMapping("/registration")
	public MessageResponse registration(@RequestBody UserRegistrationDTO userDTO,@RequestParam("chosenareas") List<String>chosenareas) {
		
		
		
		if(userDTO.getOpt().equals("A")){
			
			
			Author auth=new Author();
			auth.setName(userDTO.getName());
			auth.setSurname(userDTO.getSurname());
			auth.setCity(userDTO.getCity());
			auth.setCountry(userDTO.getCountry());
			auth.setUsername(userDTO.getUsername());
			auth.setPassword(userDTO.getPassword());
			auth.setEmail(userDTO.getEmail());
			Author saved=userService.registrateAuthor(auth);
			
			
			if(saved!=null){
				
				return new MessageResponse("Registration success");
			}
			else{
				
				return new MessageResponse("Registration fails");
			}
			
			
			
			
		}else if(userDTO.getOpt().equals("E")){
		
			
			Editor e=new Editor();
			e.setName(userDTO.getName());
			e.setSurname(userDTO.getSurname());
			e.setCity(userDTO.getCity());
			e.setCountry(userDTO.getCountry());
			e.setTitle(userDTO.getTitle());
			e.setUsername(userDTO.getUsername());
			e.setPassword(userDTO.getPassword());
			e.setEmail(userDTO.getEmail());
			e.setRecensent(false);
			
			System.out.println(e.getName());
			

			Editor saved=userService.registrateEditor(e);	
			
		System.out.println(chosenareas.size()+" duzina niya");
			
			for(int i=0;i<chosenareas.size();i++){
				
				ScienceArea found=scienceAreaService.findScienceAreaByName(chosenareas.get(i));
				
			
				EditorArea ea=new EditorArea();
				ea.setEditor(e);
				ea.setSarea(found);
				
				EditorArea sav=editoreAreaService.saveEditorArea(ea);
				if(sav==null){
					return new MessageResponse("Registration fails");
				}
				
			
			
			}
			
		
			
             if(saved!=null ){
				
				return new MessageResponse("Registration success");
			}
			else{
				
				return new MessageResponse("Registration fails");
			}
		}else if(userDTO.getOpt().equals("R")){
			
			
			
			
			Recensent r=new Recensent();
			r.setName(userDTO.getName());
			r.setSurname(userDTO.getSurname());
			r.setCity(userDTO.getCity());
			r.setCountry(userDTO.getCountry());
			r.setTitle(userDTO.getTitle());
			r.setUsername(userDTO.getUsername());
			r.setPassword(userDTO.getPassword());
			r.setEmail(userDTO.getEmail());
			
			

			Recensent saved=userService.registrateRecensent(r);	
			
		System.out.println(chosenareas.size()+" duzina niya");
			
			for(int i=0;i<chosenareas.size();i++){
				
				ScienceArea found=scienceAreaService.findScienceAreaByName(chosenareas.get(i));
				
			
				RecensentArea ea=new RecensentArea();
				ea.setRecensent(r);
				ea.setSarea(found);
				
				RecensentArea sav=recensentAreaService.saveRecensentArea(ea);
				if(sav==null){
					return new MessageResponse("Registration fails");
				}
				
			
			
			}
			
		
			
             if(saved!=null ){
				
				return new MessageResponse("Registration success");
			}
			else{
				
				return new MessageResponse("Registration fails");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		return null;
		
	}




	



}