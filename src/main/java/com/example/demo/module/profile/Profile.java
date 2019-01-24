package com.example.demo.module.profile;

import com.example.demo.module.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String bio;
    private String email;
    private ProfileStatus status;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
