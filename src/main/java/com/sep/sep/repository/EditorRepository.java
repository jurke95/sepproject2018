package com.sep.sep.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Editor;


@Repository
public interface EditorRepository extends JpaRepository<Editor,Long> {
	
	Editor findOneById(Long id);
	Optional<Editor> findOneByEmail(String email);

}
