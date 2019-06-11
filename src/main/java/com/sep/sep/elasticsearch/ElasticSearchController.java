package com.sep.sep.elasticsearch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.elasticsearch.index.query.QueryBuilders.*;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.apache.lucene.search.join.ScoreMode;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;



@RestController
@RequestMapping("/search")
@CrossOrigin(origins="http://localhost:3006",allowedHeaders="*")
public class ElasticSearchController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	
    private static final String ingestUrl = "http://localhost:9200/index_article/";
	
   
	
	
	
	
	@GetMapping("/getArticlesByName/{name}")
	public List<Article>getArticlesByName(@PathVariable String name) {

		
		List<Article>lista=articleService.findByArticleName(name);
		
		
		return lista;

	}
	
	@GetMapping("/getArticlesByMagazine/{name}")
	public List<Article>getArticlesByMagazine(@PathVariable String name) {

		
		List<Article>lista=articleService.findByMagazineName(name);
		
		
		return lista;

	}
	
	@GetMapping("/getArticlesByAuthor/{name}/{surname}")
	public List<Article>getArticlesByMagazine(@PathVariable String name,@PathVariable String surname) {
		
		System.out.println(name);
		System.out.println(surname);

		
		List<Article>lista=articleService.findByAuthorNameAndSurname(name, surname);
		
		
		return lista;

	}
	
	@GetMapping("/getArticlesByArea/{name}")
	public List<Article>getArticlesByArea(@PathVariable String name) {

		
		List<Article>lista=articleService.findByScienceArea(name);
		
		
		return lista;

	}
	
	@GetMapping("/getArticlesByKeyword/{name}")
	public List<Article>getArticlesByKeyword(@PathVariable String name) {

		
		List<Article>lista=articleService.findByKeyword(name);
		
		
		return lista;

	}
	


}
