package com.example.demo.module.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Article getOne(Long id) {
        return articleRepository.getOne(id);
    }
}
