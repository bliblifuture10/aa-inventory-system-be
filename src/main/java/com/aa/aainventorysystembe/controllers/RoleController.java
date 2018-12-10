package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Response;
import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController extends GlobalController{

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public Response<List<Role>> getAllRole(){
        return toResponse(roleRepository.findAll());
    }

    @GetMapping("/{name}")
    public Response<Role> getRoleByName(@PathVariable String name){
        return toResponse(roleRepository.findByName(name));
    }

    @PostMapping
    public Response<Role> addRole(@Valid @RequestBody Role role){
        return toResponse(roleRepository.save(role));
    }

}
