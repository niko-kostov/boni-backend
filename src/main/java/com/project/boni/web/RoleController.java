package com.project.boni.web;

import com.project.boni.model.Role;
import com.project.boni.model.dto.AddRoleDto;
import com.project.boni.service.RoleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/role", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/admin")
    public Role createRole(@RequestBody AddRoleDto addRoleDto){
        return this.roleService.save(addRoleDto);
    }

    @DeleteMapping("admin/{id}")
    public Role deleteRole(@PathVariable Long id){
        return this.roleService.delete(id);
    }
}
