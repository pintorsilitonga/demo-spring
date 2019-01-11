package com.example.demo.module.article;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.module.comment.Comment;
import com.example.demo.module.comment.CommentRepository;
import com.example.demo.module.profile.Profile;
import com.example.demo.module.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ArticleResolver implements GraphQLResolver<Article> {
    private CommentRepository commentRepository;
    private ProfileRepository profileRepository;

    public Profile getAuthor(Article article) {
        return profileRepository.getOne(article.getAuthorId());
    }

    public List<Comment> getComments(Article article) {
        return commentRepository.findByArticleId(article.getId());
    }
}
