package com.example.demo.module.article;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class ArticleQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private ArticleService articleService;

    public Iterable<Article> getArticles() {

        return articleService.getAll();
    }

    @Transactional
    public Article getArticle(Long id) {
        return articleService.findOne(id);
    }
}
