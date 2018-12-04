package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("")
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    @GetMapping("/{name}")
    public Role getRoleByName(@PathVariable String name){
        return roleRepository.findByName(name);
    }

    @PostMapping("")
    public Role addRole(@Valid @RequestBody Role role){
        return roleRepository.save(role);
    }

}
