package com.sep.sep.elasticsearch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "index_article", type = "article")
public class Article {
 
    @Id
    private String id;
     
    private String name;
    
    private String sciencearea;
    
    private String magazine;
     
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;
    
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Keyword> keywords;
    
    @Field(type = FieldType.Text)
    private byte[] pdf;
    
    public Article(){
    	
    }

	
    
    
	public Article(String id, String name, String sciencearea, String magazine, List<Author> authors,
			List<Keyword> keywords) {
		super();
		this.id = id;
		this.name = name;
		this.sciencearea = sciencearea;
		this.magazine = magazine;
		this.authors = authors;
		this.keywords = keywords;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<Keyword> getKeywords() {
		
		if(keywords==null){
			keywords=new ArrayList<Keyword>();
		}
		return keywords;
	}




	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}




	public String getSciencearea() {
		return sciencearea;
	}

	public void setSciencearea(String sciencearea) {
		this.sciencearea = sciencearea;
	}

	public String getMagazine() {
		return magazine;
	}

	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

	public List<Author> getAuthors() {
		
		if(authors==null){
			authors=new ArrayList<Author>();
		}
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}




	public byte[] getPdf() {
		return pdf;
	}




	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
     
    // standard getters and setters
    
    
}
