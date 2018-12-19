package com.sep.sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.Editor;


@Repository
public interface EditorRepository extends JpaRepository<Editor,Long> {
	
	Editor findOneById(Long id);

}
