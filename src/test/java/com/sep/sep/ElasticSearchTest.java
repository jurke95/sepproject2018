package com.sep.sep;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.elasticsearch.action.index.IndexResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.sep.sep.elasticsearch.Article;
import com.sep.sep.elasticsearch.ArticleService;
import com.sep.sep.elasticsearch.Author;

import com.sep.sep.elasticsearch.Keyword;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SepApplication.class)
public class ElasticSearchTest {
	
	//@Autowired
	//private AuthorRepository authRepository;
	
	@Autowired
	private ArticleService articleService;
	
	 private static final String ingestUrl = "http://localhost:9200/index_article/article/";
	
	
	 @Autowired
	 private ElasticsearchTemplate esTemplate;
	 
	 
	 @Before
	    public void before() {
	        esTemplate.deleteIndex(Article.class);
	        esTemplate.createIndex(Article.class);
	        esTemplate.putMapping(Article.class);
	        esTemplate.refresh(Article.class);
	    }
	 
	 @Test
	    public void testSave() {
		 
		 String fp = System.getProperty("user.dir");
		 String fpp=new String(fp+"\\MagazineBase\\");
		 String originalFileName = "3.Kreditni rizik i kreditni derivati.pdf";
		 String originalFileName2 = "2.Uticaj trgovinskih i bankarskih kredita na svetski izvoz.pdf";
		  byte[] input_file;
		  byte[] input_file2;
		
		  
		try {
			input_file = Files.readAllBytes(Paths.get(fpp+originalFileName));
			input_file2 = Files.readAllBytes(Paths.get(fpp+originalFileName2));
			 String encodedBytes  = Base64.getEncoder().encodeToString(input_file);
			 String encodedBytes2 = Base64.getEncoder().encodeToString(input_file2);


			// byte[] encodedBytes = Base64.getEncoder().encode(input_file);
			// byte[] encodedBytes2 = Base64.getEncoder().encode(input_file2);
			  Author author=new Author();
		       author.setName("Marko");
		       author.setSurname("Jurić");
		       
		       Author author2=new Author();
		       author2.setName("Saska");
		       author2.setSurname("Grujic");
		       
		       Author author3=new Author();
		       author3.setName("Dragan");
		       author3.setSurname("Dulic");
		       
		       Keyword kw1=new Keyword("proizvodnja");
		       Keyword kw2=new Keyword("vodonik");
		       Keyword kw3=new Keyword("energija");
		       
		       Keyword kw4=new Keyword("kredit");
		       Keyword kw5=new Keyword("izvoz");
		       Keyword kw6=new Keyword("uticaj");
			 
		        Article article=new Article();
		        article.setId("1");
		      
		        article.setName("2.Tehnologije proizvodnje vodonika koriscenjem solarne energije.pdf");
		        article.setMagazine("Zastita prirode");
		        article.setSciencearea("Ekologija");
		        
		        //article.setPdf(encodedBytes);
		        article.getKeywords().add(kw1);
		        article.getKeywords().add(kw2);
		        article.getKeywords().add(kw3);
		        article.getAuthors().add(author);
		        article.getAuthors().add(author2);
		       
		        Article a=articleService.save(article);
		        RestTemplate rest = new RestTemplate();
		        HttpHeaders headers = new HttpHeaders();
		        headers.add("Content-Type", "application/json");
		        headers.add("Accept", "*/*");

		        String requestString = "{\"data\":\""+encodedBytes+"\"}";

		        HttpEntity<String> requestEntity = new HttpEntity<>(requestString,headers);
		        ResponseEntity<?> responseEntity;

		        Long idd= Long.parseLong(article.getId());
		        System.out.println(idd);
		        System.out.println(encodedBytes);
		      //  responseEntity = rest.exchange("http://localhost:9200/index_article/article/"+"_ingest/pipeline/attachment", HttpMethod.PUT, requestEntity, String.class);
		        rest.put("http://localhost:9200/_ingest/pipeline/attachment",null);
		        responseEntity = rest.exchange(ingestUrl+idd+"?pipeline=attachment", HttpMethod.PUT, requestEntity, String.class);
		        
		        Article article2=new Article();
		        article2.setId("2");
		        article2.setName("2.Uticaj trgovinskih i bankarskih kredita na svetski izvoz.pdf");
		        article2.setMagazine("Bankarstvo");
		        article2.setSciencearea("Ekonomija");
		        article2.getKeywords().add(kw4);
		        article2.getKeywords().add(kw5);
		        article2.getKeywords().add(kw6);
		        article2.getAuthors().add(author3);
		       // article2.setPdf(encodedBytes2);
		       
		        Article p=articleService.save(article2);
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	       

	     
	        
	      
	    }

}
