package com.example.demo.module.comment;

import com.example.demo.module.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List findByArticleId(long articleId);
}
