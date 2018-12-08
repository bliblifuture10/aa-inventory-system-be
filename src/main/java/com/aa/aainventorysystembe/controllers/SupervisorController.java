package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.entity.Supervisor;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import com.aa.aainventorysystembe.repositories.SupervisorRepository;
import com.aa.aainventorysystembe.services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supervisor")
public class SupervisorController {
    @Autowired
    SupervisorService supervisorService;

    //GET
    @GetMapping("")
    public List<Supervisor> getAllSupervisor(){
        return supervisorService.getAllSupervisor();
    }

    @GetMapping("/id/{spvId}")
    public Optional<Supervisor> getSupervisor(@PathVariable String spvId){
        return supervisorService.getSupervisorById(spvId);
    }

    @GetMapping("/name/{name}")
    public List<Supervisor> getSupervisorByName(@PathVariable String name){
        return supervisorService.getAllSupervisorByName(name);
    }

    //CRUD
    @PostMapping("")
    public Supervisor addSupervisor(@Valid @RequestBody Supervisor supervisor){
        return supervisorService.createSupervisor(supervisor);
    }

    @PutMapping("/id/{spvId}")
    public Supervisor updateSupervisor(@PathVariable String spvId, @Valid @RequestBody Supervisor supervisor){
        return null;
    }

    @DeleteMapping("/id/{spvId}")
    public void deleteSupervisor(@PathVariable String spvId){
        supervisorService.deleteSupervisor(spvId);
    }

}
