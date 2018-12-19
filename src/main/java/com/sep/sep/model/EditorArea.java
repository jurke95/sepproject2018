package com.sep.sep.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EditorArea {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="editor_id")
	private Editor editor;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="sarea_id")
	private ScienceArea sarea;
	
	
	
	public EditorArea(){
		
	}
	
	
	
	


	public EditorArea(Long id, Editor editor, ScienceArea sarea) {
		super();
		this.id = id;
		this.editor = editor;
		this.sarea = sarea;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Editor getEditor() {
		return editor;
	}


	public void setEditor(Editor editor) {
		this.editor = editor;
	}


	public ScienceArea getSarea() {
		return sarea;
	}


	public void setSarea(ScienceArea sarea) {
		this.sarea = sarea;
	}
	
	
	
	
	
	
	
	
	

}
