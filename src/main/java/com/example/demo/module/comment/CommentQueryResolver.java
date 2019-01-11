package com.example.demo.module.comment;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CommentQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CommentService commentService;

    public List<Comment> getComments() {
        return commentService.getAll();
    }
}
