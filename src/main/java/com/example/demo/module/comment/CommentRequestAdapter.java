package com.example.demo.module.comment;

import com.example.demo.module.article.ArticleService;
import com.example.demo.module.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentRequestAdapter {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ArticleService articleService;

    public Comment toComment(CommentRequest request) {
        Comment comment = new Comment();

        updateComment(comment, request);
        return comment;
    }

    public void updateComment(Comment comment, CommentRequest request) {
        comment.setText(request.getText());
        comment.setArticle(articleService.findById(request.getArticleId()));
        comment.setProfile(profileService.findById(request.getProfileId()));
    }
}
