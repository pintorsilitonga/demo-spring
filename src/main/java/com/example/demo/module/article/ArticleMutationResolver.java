package com.example.demo.module.article;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class ArticleMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRequestAdapter articleRequestAdapter;

    @Transactional
    public Article addArticle(ArticleRequest articleRequest) {
        Article article = articleRequestAdapter.toArticle(articleRequest);

        return articleService.addArticle(article);
    }
}
