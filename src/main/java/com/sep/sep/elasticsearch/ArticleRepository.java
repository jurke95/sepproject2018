package com.sep.sep.elasticsearch;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
	
	List<Article> findOneByName(String name);
	List<Article> findOneByMagazine(String name);
	List<Article> findOneBySciencearea(String name);
	List<Article> findByAuthorsNameAndAuthorsSurname(String name,String surname);
	List<Article> findByKeywordsName(String name);
	

}

