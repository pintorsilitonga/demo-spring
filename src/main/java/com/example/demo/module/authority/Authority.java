package com.example.demo.module.authority;

import com.example.demo.module.role.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Authority {
    @Id
    private String id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "authority_role",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
