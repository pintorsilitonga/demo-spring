package com.example.demo.module.comment;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class CommentMutationResolver implements GraphQLMutationResolver {
    @Autowired private CommentService commentService;
    @Autowired private CommentRequestAdapter adapter;

    @Transactional
    public Comment addComment(CommentRequest request) {
        Comment comment = adapter.toComment(request);

        return commentService.addComment(comment);
    }

    @Transactional
    public Comment editComment(Long id, String text) {
        Comment comment = commentService.findById(id);
        comment.setText(text);

        return commentService.update(comment);
    }
}
