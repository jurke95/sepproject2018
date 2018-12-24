package com.sep.sep.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sep.sep.controller.dto.UserLoginDTO;
import com.sep.sep.controller.dto.UserRegistrationDTO;
import com.sep.sep.controller.response.LoginTokenResponse;
import com.sep.sep.model.Author;
import com.sep.sep.model.Editor;
import com.sep.sep.model.EditorArea;
import com.sep.sep.model.Recensent;
import com.sep.sep.model.RecensentArea;
import com.sep.sep.model.ScienceArea;
import com.sep.sep.response.MessageResponse;
import com.sep.sep.security.TokenProvider;
import com.sep.sep.security.UserDetailsServiceImpl;
import com.sep.sep.service.EditorAreaService;
import com.sep.sep.service.RecensentAreaService;
import com.sep.sep.service.ScienceAreaService;
import com.sep.sep.service.UserService;
import com.sep.sep.validation.PasswordMatchesValidator;



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
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@PostMapping("/registration")
	public MessageResponse registration(@RequestBody @Valid UserRegistrationDTO userDTO,@RequestParam("chosenareas") List<String>chosenareas) {
		
		
		
		if(userDTO.getOpt().equals("A")){
			
			Optional<Author> checkedE=userService.getAuthorByEmail(userDTO.getEmail());
			if(checkedE.isPresent()){
				
				return new MessageResponse("There is already author with the same email");
			}
			
			Author checkedU=userService.getAuthorByUsername(userDTO.getUsername());
			if(checkedU!=null){
				
				return new MessageResponse("There is already author with the same username");
			}
			
			PasswordMatchesValidator pass = new PasswordMatchesValidator();
			if (pass.isValid(userDTO) == false) {
				return new MessageResponse("You must retype the same password again");
			}
			
			
			
			
			Author auth=new Author();
			auth.setName(userDTO.getName());
			auth.setSurname(userDTO.getSurname());
			auth.setCity(userDTO.getCity());
			auth.setCountry(userDTO.getCountry());
			auth.setUsername(userDTO.getUsername());
			auth.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			auth.setEmail(userDTO.getEmail());
			Author saved=userService.registrateAuthor(auth);
			
			
			if(saved!=null){
				
				return new MessageResponse("Registration success");
			}
			else{
				
				return new MessageResponse("Registration fails");
			}
			
			
			
			
		}else if(userDTO.getOpt().equals("E")){
			
			
			Optional<Editor> checkedE=userService.getEditorByEmail(userDTO.getEmail());
			if(checkedE.isPresent()){
				
				return new MessageResponse("There is already editor with the same email");
			}
			
			Editor checkedU=userService.getEditorByUsername(userDTO.getUsername());
			if(checkedU!=null){
				
				return new MessageResponse("There is already editor with the same username");
			}
		
			
			PasswordMatchesValidator pass = new PasswordMatchesValidator();
			if (pass.isValid(userDTO) == false) {
				return new MessageResponse("You must retype the same password again");
			}
			
			Editor e=new Editor();
			e.setName(userDTO.getName());
			e.setSurname(userDTO.getSurname());
			e.setCity(userDTO.getCity());
			e.setCountry(userDTO.getCountry());
			e.setTitle(userDTO.getTitle());
			e.setUsername(userDTO.getUsername());
			e.setPassword(passwordEncoder.encode(userDTO.getPassword()));
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
			
			
			

			Optional<Recensent> checkedR=userService.getRecensentByEmail(userDTO.getEmail());
			if(checkedR.isPresent()){
				
				return new MessageResponse("There is already recensent with the same email");
			}
			
			Recensent checkedU=userService.getRecensentByUsername(userDTO.getUsername());
			if(checkedU!=null){
				
				return new MessageResponse("There is already recensent with the same username");
			}
			
			
			PasswordMatchesValidator pass = new PasswordMatchesValidator();
			if (pass.isValid(userDTO) == false) {
				return new MessageResponse("You must retype the same password again");
			}
			
			Recensent r=new Recensent();
			r.setName(userDTO.getName());
			r.setSurname(userDTO.getSurname());
			r.setCity(userDTO.getCity());
			r.setCountry(userDTO.getCountry());
			r.setTitle(userDTO.getTitle());
			r.setUsername(userDTO.getUsername());
			r.setPassword(passwordEncoder.encode(userDTO.getPassword()));
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
	
	
	@JsonValue
	@PostMapping("/login")
	public LoginTokenResponse loginUser(@RequestBody UserLoginDTO loginDTO) {
		
		Optional<Author> tempA = userService.getAuthorByEmail(loginDTO.getUsername());
		Optional<Editor> tempE = userService.getEditorByEmail(loginDTO.getUsername());
		Optional<Recensent> tempR = userService.getRecensentByEmail(loginDTO.getUsername());
		
		if(tempA.isPresent()){
			
			
			if(!passwordEncoder.matches(loginDTO.getPassword(), tempA.get().getPassword())) {
				return null;
			}
			
			
			UserDetails details = userDetailsServiceImpl.loadUserByUsername(loginDTO.getUsername());
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());

			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = tokenProvider.generateToken(details);

			String role = details.getAuthorities().stream().findFirst().get().getAuthority();

			return new LoginTokenResponse(tempA.get(),null,null, jwt);
		}
		
		
		else if(tempE.isPresent()){
			
			if(!passwordEncoder.matches(loginDTO.getPassword(), tempE.get().getPassword())) {
				return null;
			}
			
			
			UserDetails details = userDetailsServiceImpl.loadUserByUsername(loginDTO.getUsername());
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());

			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = tokenProvider.generateToken(details);

			String role = details.getAuthorities().stream().findFirst().get().getAuthority();

			return new LoginTokenResponse(null,tempE.get(),null, jwt);
			
		}
		
         else if(tempR.isPresent()){
			
			if(!passwordEncoder.matches(loginDTO.getPassword(), tempR.get().getPassword())) {
				return null;
			}
			
			
			UserDetails details = userDetailsServiceImpl.loadUserByUsername(loginDTO.getUsername());
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());

			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = tokenProvider.generateToken(details);

			String role = details.getAuthorities().stream().findFirst().get().getAuthority();

			return new LoginTokenResponse(null,null,tempR.get(), jwt);
			
		}
		
          return null;

	}
	
	@PostMapping("/logout")
	public MessageResponse logout(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		SecurityContextHolder.getContext().setAuthentication(null);
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return new MessageResponse("User is logged out");
	}



}