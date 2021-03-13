package com.project.boni.service.Impl;

import com.project.boni.model.Role;
import com.project.boni.model.dto.AddRoleDto;
import com.project.boni.repository.RoleRepository;
import com.project.boni.service.RoleService;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.HashSet;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public Role find(Long id) {
        return this.roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Role with id: %s not found", String.valueOf(id))));
    }

    @Override
    public Role save(AddRoleDto addRoleDto) {
        Role role = new Role();
        role.setName(addRoleDto.getName());
        role.setActive(true);
        role.setDeleted(false);
        role.setUsers(new HashSet<>());

        return this.roleRepository.save(role);
    }

    @Override
    public Role delete(Long id) {
        Role deletedRole = this.find(id);

        this.roleRepository.delete(deletedRole);

        return deletedRole;
    }
}
