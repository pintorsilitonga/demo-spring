package com.example.demo.module.article;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArticleQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private ArticleService articleService;

    public Iterable<Article> getArticles() {

        return articleService.getAll();
    }

    public Article getArticle(Long id) {
        return articleService.findOne(id);
    }
}
