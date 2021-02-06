package com.project.boni.service;

import com.project.boni.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role find(Long id);

    Role save(Role role);
}
