package com.example.demo.module.comment;

import com.example.demo.module.article.Article;
import com.example.demo.module.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
    List findByArticleId(long articleId);
}
