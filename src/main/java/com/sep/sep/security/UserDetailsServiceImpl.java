package com.sep.sep.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;
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
import com.sep.sep.model.RegUser;
import com.sep.sep.repository.AuthorRepository;
import com.sep.sep.repository.EditorRepository;
import com.sep.sep.repository.RecensentRepository;
import com.sep.sep.repository.RegUserRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private RegUserRepository userRepository;
	
	@Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        Optional<RegUser> userByUsernameFromDatabase = userRepository.findOneByEmail(username);
        return userByUsernameFromDatabase.map(user -> this.createSpringSecurityUser(user)).orElseThrow(() ->
                new UsernameNotFoundException("User " + username + " was not found in the " +
                        "database"));
    }

    public org.springframework.security.core.userdetails.User createSpringSecurityUser(RegUser user) {
        if (!user.isActive()) {
            throw new IllegalArgumentException("User " + user.getEmail() + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }
}
