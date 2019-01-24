package com.example.demo.module.role;

import com.example.demo.module.authority.Authority;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "authority_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;
}
