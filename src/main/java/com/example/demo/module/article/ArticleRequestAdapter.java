package com.example.demo.module.article;

import com.example.demo.module.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleRequestAdapter {

    @Autowired
    private ProfileService profileService;

    public Article toArticle(ArticleRequest articleRequest) {
        Article article = new Article();

        updateArticle(article, articleRequest);

        return article;
    }

    public void updateArticle(Article article, ArticleRequest articleRequest) {
        article.setText(articleRequest.getText());
        article.setTitle(articleRequest.getTitle());
        article.setProfile(profileService.getById(articleRequest.getProfileId()));
    }

    public void deleteArticle(Article article) {
        article.setActive(false);
    }

    public void undeleteArticle(Article article) {
        article.setActive(true);
    }
}
