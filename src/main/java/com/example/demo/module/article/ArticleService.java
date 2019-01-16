package com.example.demo.module.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Iterable<Article> getAll() {
        return articleRepository.findAll();
    }

    public Article findOne(Long id) {
        return articleRepository.findById(id).get();
    }

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
}
