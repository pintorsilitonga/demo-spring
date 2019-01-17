package com.example.demo.module.comment;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.module.article.Article;
import com.example.demo.module.article.ArticleService;
import com.example.demo.module.profile.Profile;
import com.example.demo.module.profile.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentResolver implements GraphQLResolver<Comment> {
    @Autowired private ProfileService profileService;
    @Autowired private ArticleService articleService;

    public Profile getProfile(Comment comment) {
        return profileService.findById(comment.getProfile().getId());
    }

    public Article getArticle(Comment comment) {
        return articleService.findById(comment.getArticle().getId());
    }
}
