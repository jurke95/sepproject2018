package com.sep.sep.elasticsearch;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private  ArticleRepository articleRepository;

	@Override
	public Article save(Article article) {
		// TODO Auto-generated method stub
		return articleRepository.save(article);
	}

	@Override
	public Optional<Article> findOne(String id) {
		// TODO Auto-generated method stub
		return articleRepository.findById(id);
	}

	@Override
	public Iterable<Article> findAll() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public List<Article> findByArticleName(String name) {
		// TODO Auto-generated method stub
		return articleRepository.findOneByName(name);
	}

	@Override
	public List<Article> findByAuthorName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findByAuthorSurname(String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findByAuthorNameAndSurname(String name, String surname) {
		// TODO Auto-generated method stub
		return articleRepository.findByAuthorsNameAndAuthorsSurname(name, surname);
	}

	@Override
	public void delete(Article article) {
		// TODO Auto-generated method stub
		articleRepository.delete(article);
		
	}

	@Override
	public List<Article> findByMagazineName(String name) {
		// TODO Auto-generated method stub
		return articleRepository.findOneByMagazine(name);
	}

	@Override
	public List<Article> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return articleRepository.findByKeywordsName(keyword);
	}

	@Override
	public List<Article> findByScienceArea(String area) {
		// TODO Auto-generated method stub
		return articleRepository.findOneBySciencearea(area);
	}


}
