package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.Response;
import com.aa.aainventorysystembe.models.entity.Supervisor;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import com.aa.aainventorysystembe.repositories.SupervisorRepository;
import com.aa.aainventorysystembe.services.SupervisorService;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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
    public Response<Supervisor> addSupervisor(
            @RequestParam MultipartFile file,
            @Valid @ModelAttribute Supervisor supervisor
    ){
        String imageValue = null;

        try{
            imageValue = saveUploadedFiles(file, "supervisors");
        }catch (IOException e){}

        return toResponse(supervisorService.createSupervisor(supervisor, imageValue));
    }

    @PutMapping("/id/{id}")
    public Response<Supervisor> updateSupervisor(
            @PathVariable String id,
            @RequestParam MultipartFile file,
            @Valid @ModelAttribute Supervisor supervisorReq
    ){
        String imageValue = null;

        try{
            imageValue = saveUploadedFiles(file, "supervisors");
        }catch (IOException e){}

        return toResponse(supervisorService.updateSupervisorById(id, supervisorReq, imageValue));
    }

    @DeleteMapping("/id/{id}")
    public Response<Boolean> deleteSupervisor(@PathVariable String id){
        return toResponse(supervisorService.deleteSupervisorById(id));
    }

}
