package com.example.demo.module.comment;

import com.example.demo.module.profile.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Long articleId;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
