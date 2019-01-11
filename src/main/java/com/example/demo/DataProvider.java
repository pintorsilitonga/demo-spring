package com.example.demo;

import com.example.demo.module.article.Article;
import com.example.demo.module.article.ArticleRepository;
import com.example.demo.module.comment.Comment;
import com.example.demo.module.comment.CommentRepository;
import com.example.demo.module.profile.Profile;
import com.example.demo.module.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class DataProvider implements CommandLineRunner {
    private CommentRepository commentRepository;
    private ArticleRepository articleRepository;
    private ProfileRepository profileRepository;

    @Override
    @Transactional
    public void run(String... strings) {
//        Profile author = profileRepository.save(new Profile(null, "Pintor", "Senpai of this Demo project"));
//        Profile admin = profileRepository.save(new Profile(null, "Jonathan", "Kouhai of this Demo project"));
//        Article article1 = articleRepository.save(new Article(null, "Hello world", "This is dog", author.getId()));
//        Article article2 = articleRepository.save(new Article(null, "Hello you", "This is cat", admin.getId()));
//        commentRepository.save(new Comment(null, "Like that", article1.getId(), author.getId()));
//        commentRepository.save(new Comment(null, "wakacipaw", article1.getId(), admin.getId()));
//        commentRepository.save(new Comment(null, "asaksdskwi", article2.getId(), admin.getId()));
    }
}
