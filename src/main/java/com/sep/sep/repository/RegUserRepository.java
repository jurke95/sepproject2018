package com.sep.sep.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Author;
import com.sep.sep.model.RegUser;

@Repository
public interface RegUserRepository extends JpaRepository<RegUser,Long> {
	
	RegUser findOneById(Long id);
	Optional<RegUser> findOneByEmail(String email);
	RegUser findOneByUsername(String username);
	RegUser findByEmail(String email);
}
