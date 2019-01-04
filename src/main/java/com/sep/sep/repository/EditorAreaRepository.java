package com.sep.sep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sep.sep.model.EditorArea;




@Repository
public interface EditorAreaRepository extends JpaRepository<EditorArea,Long> {
	
	EditorArea findOneById(Long id);
	@Query("select ea.sarea.name from EditorArea ea where (ea.editor.email)=(:editormail)")
	List<String> findEditorAreaNames(@Param("editormail")String editormail);
	

}