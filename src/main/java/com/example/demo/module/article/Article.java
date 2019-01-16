package com.example.demo.module.article;

import com.example.demo.module.profile.Profile;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Setter
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}