package com.example.demo.module.article;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Article deleteArticle(Long id) {
        Article article = articleService.findById(id);

        articleRequestAdapter.deleteArticle(article);

        return articleService.update(article);
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Article undeleteArticle(Long id) {
        Article article = articleService.findById(id);

        articleRequestAdapter.undeleteArticle(article);

        return articleService.update(article);
    }

    @Transactional
    public Article editArticle(Long id, ArticleRequest request) {
        Article article = articleService.findById(id);

        articleRequestAdapter.updateArticle(article, request);

        return articleService.update(article);
    }
}
