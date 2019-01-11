package com.example.demo.module.article;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ArticleQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private ArticleService articleService;

    public List<Article> getArticles() {
        return articleService.getAll();
    }

    public Article getArticle(Long id) {
        return articleService.getOne(id);
    }
}
