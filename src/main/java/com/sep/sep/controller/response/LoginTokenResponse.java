package com.sep.sep.controller.response;

import com.sep.sep.model.Author;
import com.sep.sep.model.Editor;
import com.sep.sep.model.Recensent;

public class LoginTokenResponse {
	
	
	private Author author;
	private Editor editor;
	private Recensent recensent;
	private String jwt;

	
	
	public LoginTokenResponse(){
		
		
		
	}

	
	
	


	public LoginTokenResponse(Author author, Editor editor, Recensent recensent, String jwt) {
		super();
		this.author = author;
		this.editor = editor;
		this.recensent = recensent;
		this.jwt = jwt;
	}






	public Author getAuthor() {
		return author;
	}



	public void setAuthor(Author author) {
		this.author = author;
	}



	public Editor getEditor() {
		return editor;
	}



	public void setEditor(Editor editor) {
		this.editor = editor;
	}



	public Recensent getRecensent() {
		return recensent;
	}



	public void setRecensent(Recensent recensent) {
		this.recensent = recensent;
	}



	public String getJwt() {
		return jwt;
	}



	public void setJwt(String jwt) {
		this.jwt = jwt;
	}



	
	
	
	
}