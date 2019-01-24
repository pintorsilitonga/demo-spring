package com.example.demo.module.role;

import lombok.Data;

import java.util.Set;

@Data
public class RoleRequest {
    private String description;
    private String name;
    private Set<String> authorityIds;
}
