package com.project.boni.service;

import com.project.boni.model.Role;
import com.project.boni.model.dto.AddRoleDto;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role find(Long id);

    Role save(AddRoleDto addRoleDto);

    Role delete(Long id);
}
