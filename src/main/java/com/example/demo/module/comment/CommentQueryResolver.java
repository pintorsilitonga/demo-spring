package com.example.demo.module.comment;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CommentService commentService;

    public Iterable<Comment> getComments() {
        return commentService.getAll();
    }
}
