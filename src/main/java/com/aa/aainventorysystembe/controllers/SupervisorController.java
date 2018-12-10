package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.Response;
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
public class SupervisorController extends GlobalController{
    @Autowired
    SupervisorService supervisorService;

    @GetMapping
    public Response<List<Supervisor>> getAllSupervisor(){
        return toResponse(supervisorService.getAllSupervisor());
    }

    @GetMapping("/id/{id}")
    public Response<Supervisor> getSupervisorById(@PathVariable String id){
        return toResponse(supervisorService.getSupervisorById(id));
    }

    @GetMapping("/name/{name}")
    public Response<List<Supervisor>> getSupervisorByName(@PathVariable String name){
        return toResponse(supervisorService.getAllSupervisorByName(name));
    }

    @PostMapping
    public Response<Supervisor> addSupervisor(@Valid @RequestBody Supervisor supervisor){
        return toResponse(supervisorService.createSupervisor(supervisor));
    }

    @PutMapping("/id/{id}")
    public Response<Supervisor> updateSupervisor(@PathVariable String id, @Valid @RequestBody Supervisor supervisorReq){
        return toResponse(supervisorService.updateSupervisorById(id, supervisorReq));
    }

    @DeleteMapping("/id/{id}")
    public Response<Boolean> deleteSupervisor(@PathVariable String id){
        return toResponse(supervisorService.deleteSupervisorById(id));
    }

}
