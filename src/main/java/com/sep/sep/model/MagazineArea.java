package com.sep.sep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class MagazineArea {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@OneToOne
	@JoinColumn(name="sarea_id")
	private ScienceArea sarea;
	
	
	@OneToOne
	@JoinColumn(name="editor_id")
	private Editor editor;
	
	
	@ManyToOne
	@JoinColumn(name = "magazine_id")
	private Magazine magazine;	 
	

	

	public MagazineArea(Long id, ScienceArea sarea, Editor editor, Magazine magazine) {
		super();
		this.id = id;
		this.sarea = sarea;
		this.editor = editor;
		this.magazine = magazine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public ScienceArea getSarea() {
		return sarea;
	}

	public void setSarea(ScienceArea sarea) {
		this.sarea = sarea;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}
	
	
	
	
	
	
	

}
