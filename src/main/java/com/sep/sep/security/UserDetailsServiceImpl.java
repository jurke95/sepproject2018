package com.sep.sep.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sep.sep.model.Author;
import com.sep.sep.model.Editor;
import com.sep.sep.model.Recensent;
import com.sep.sep.repository.AuthorRepository;
import com.sep.sep.repository.EditorRepository;
import com.sep.sep.repository.RecensentRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AuthorRepository aRepository;
	
	@Autowired
	private EditorRepository eRepository;
	
	@Autowired
	private RecensentRepository rRepository;
	
	
	//@Override
    @Transactional
    public UserDetails loadUserByUsernameString(final String username,String usertype) {
		
		if(usertype.equals("A")){
			 Optional<Author> userByUsernameFromDatabase = aRepository.findOneByEmail(username);
			 return userByUsernameFromDatabase.map(user -> this.createSpringSecurityUserAuthor(user)).orElseThrow(() ->
             new UsernameNotFoundException("User " + username + " was not found in the " +
                     "database"));
			
		}
		
		else if(usertype.equals("E")){
			
			 Optional<Editor> userByUsernameFromDatabase = eRepository.findOneByEmail(username);
			 return userByUsernameFromDatabase.map(user -> this.createSpringSecurityUserEditor(user)).orElseThrow(() ->
             new UsernameNotFoundException("User " + username + " was not found in the " +
                     "database"));
		}
			
		else if(usertype.equals("R")){
			 Optional<Recensent> userByUsernameFromDatabase = rRepository.findOneByEmail(username);
			 return userByUsernameFromDatabase.map(user -> this.createSpringSecurityUserRecensent(user)).orElseThrow(() ->
             new UsernameNotFoundException("User " + username + " was not found in the " +
                     "database"));
		}
		else{
			
			return null;
		}
        
        
    }

    public org.springframework.security.core.userdetails.User createSpringSecurityUserAuthor(Author user) {
        if (!user.isActive()) {
            throw new IllegalArgumentException("User " + user.getEmail() + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }
    
    
    public org.springframework.security.core.userdetails.User createSpringSecurityUserEditor(Editor user) {
        if (!user.isActive()) {
            throw new IllegalArgumentException("User " + user.getEmail() + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }
    
    
    
    public org.springframework.security.core.userdetails.User createSpringSecurityUserRecensent(Recensent user) {
        if (!user.isActive()) {
            throw new IllegalArgumentException("User " + user.getEmail() + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }
    

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}