package com.sep.sep.elasticsearch;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {
	
	
	Article save(Article article);

    Optional<Article> findOne(String id);

    Iterable<Article> findAll();
    
    List<Article> findByArticleName(String name);
    
    List<Article> findByMagazineName(String name);

    List<Article> findByAuthorName(String name);
    
    List<Article> findByAuthorSurname(String surname);
    
    List<Article> findByAuthorNameAndSurname(String name,String surname);
    
    List<Article> findByKeyword(String keyword);
    
    List<Article> findByScienceArea(String area);

    void delete(Article article);

}
