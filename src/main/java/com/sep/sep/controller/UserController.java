package com.sep.sep.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sep.sep.controller.dto.MembershipStatusDTO;
import com.sep.sep.controller.dto.UserLoginDTO;
import com.sep.sep.controller.dto.UserRegistrationDTO;
import com.sep.sep.controller.response.LoginTokenResponse;
import com.sep.sep.controller.response.LogoutResponse;
import com.sep.sep.controller.response.ObjectPayedResponse;
import com.sep.sep.controller.response.RegUserResponse;
import com.sep.sep.model.Author;
import com.sep.sep.model.Editor;
import com.sep.sep.model.EditorArea;
import com.sep.sep.model.Membership;
import com.sep.sep.model.Reader;
import com.sep.sep.model.Recensent;
import com.sep.sep.model.RecensentArea;
import com.sep.sep.model.RegUser;
import com.sep.sep.model.ScienceArea;
import com.sep.sep.model.Transaction;
import com.sep.sep.repository.MembershipRepository;
import com.sep.sep.repository.RegUserRepository;
import com.sep.sep.repository.TransactionRepository;
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
@CrossOrigin
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RegUserRepository userRepository;
	
	@Autowired
	private ScienceAreaService scienceAreaService;
	
	
	@Autowired
	private EditorAreaService editoreAreaService;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private RecensentAreaService recensentAreaService;
	
	@Autowired
	private MembershipRepository mRepository;
	
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
			
			
			
			
			
			
			
			
			
			
			
			
			
		} else if(userDTO.getOpt().equals("RR")){
			
			
			
			Optional<Reader> checkedRR=userService.getReaderByEmail(userDTO.getEmail());
			if(checkedRR.isPresent()){
				
				return new MessageResponse("There is already user with the same email");
			}
			
			Reader checkedU=userService.getReaderByUsername(userDTO.getUsername());
			if(checkedU!=null){
				
				return new MessageResponse("There is already user with the same username");
			}
			
			PasswordMatchesValidator pass = new PasswordMatchesValidator();
			if (pass.isValid(userDTO) == false) {
				return new MessageResponse("You must retype the same password again");
			}
			
			
			
			
			Reader rr=new Reader();
			rr.setName(userDTO.getName());
			rr.setSurname(userDTO.getSurname());
			rr.setCity(userDTO.getCity());
			rr.setCountry(userDTO.getCountry());
			rr.setUsername(userDTO.getUsername());
			rr.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			rr.setEmail(userDTO.getEmail());
			Reader saved=userService.registrateReader(rr);
			
			
			if(saved!=null){
				
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
		
		     String n= new String("null");
		     System.out.println(loginDTO.getEmail());
		     RegUser regu=userRepository.findByEmail(loginDTO.getEmail());
		     
		     if(regu ==null){
		    	return new LoginTokenResponse(n);
		     }
			
			if(!passwordEncoder.matches(loginDTO.getPassword(), regu.getPassword())) {
				
				return new LoginTokenResponse(n);
			}
			
			
			UserDetails details = userDetailsServiceImpl.loadUserByUsername(loginDTO.getEmail());
			
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					loginDTO.getEmail(), loginDTO.getPassword());
			
			
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			

			String jwt = tokenProvider.generateToken(details);
			

			String role = details.getAuthorities().stream().findFirst().get().getAuthority();
			
		  if(jwt!=null){
			  return new LoginTokenResponse(jwt);
		  }
			
			
				
				return null;
			}
			
			
		
	
	
	@GetMapping("/logout")
	public LogoutResponse logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//SecurityContextHolder.getContext().setAuthentication(null);
		if (auth != null) {
			System.out.println("ovo prvo  ispise");
			new SecurityContextLogoutHandler().logout(request, response, auth);
			System.out.println("ovo drugo ispise");
			 HttpSession session=request.getSession(true);  
			return new LogoutResponse("ok");
			
		}
		
		return new LogoutResponse("fail");
	}
	
	

	@GetMapping("/getLoggedUser/{jwt}")
	public RegUserResponse getLoggedUser(@PathVariable String jwt) {

		System.out.println("POGOVIDO");
		String usern=tokenProvider.getUsernameFromToken(jwt);
		Optional<RegUser> regu=userService.getRegUserByEmail(usern);
		
		RegUserResponse resp=new RegUserResponse();
		resp.setName(regu.get().getName());
		resp.setSurname(regu.get().getSurname());
		resp.setCity(regu.get().getCity());
		resp.setCountry(regu.get().getCountry());
		resp.setEmail(regu.get().getEmail());
		resp.setTitle(regu.get().getTitle());
		resp.setUsername(regu.get().getUsername());
		resp.setRole(regu.get().getRole());
		resp.setId(regu.get().getId());
		
		List<String>areaseditor=userService.getEditorsAreasNames(usern);
		System.out.println(areaseditor);
	
		
		for (int i=0;i<areaseditor.size();i++){
			resp.getAreas().add(i, areaseditor.get(i));
		}
		
		

		return resp;
	}
	
	
	@GetMapping("/getMemberships/{id}")
	public List<Membership> getMemberships(@PathVariable Long id) {

		

		return mRepository.getMembershipsByUser(id);
	}
	
	
	
	@GetMapping("/checkMembershipStatus/{id}")
	public MembershipStatusDTO checkStatus(@PathVariable Long id,HttpServletRequest request){
		
		System.out.println("Pogodio check");
		
		
	
		String j=request.getHeader("Authorization-Token");
		String usern=tokenProvider.getUsernameFromToken(j);
		Membership mm=mRepository.getMembershipByUserAndMagazine(usern, id);
		if(mm==null){
			return new MembershipStatusDTO("expired");
		}
		
		
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    	DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    	System.out.println("stigaoo");
    	try {
			Date now=formatter.parse(timeStamp);
			Date end=mm.getEndDate();
			if(now.after(end)){
				mRepository.delete(mm);
				return new MembershipStatusDTO("expired");
			}else{
				return new MembershipStatusDTO("active");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	return new MembershipStatusDTO("expired");
		
	
		
	}
	@GetMapping("/checkObjectPayment/{name}")
	public ObjectPayedResponse checkIfObjectIsPayed(@PathVariable String name,HttpServletRequest request){
		
		String j=request.getHeader("Authorization-Token");
		String usern=tokenProvider.getUsernameFromToken(j);
		
		Transaction check=transactionRepository.getPayedObject(name,usern);
		
		if(check==null){
			return new ObjectPayedResponse("no");
		}else{
			return new ObjectPayedResponse("yes");
		}
		
		
		
	}
	
	

}