package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Supervisor;
import com.aa.aainventorysystembe.repositories.SupervisorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SupervisorController {
    @Autowired
    SupervisorRepository supervisorRepository;

    @GetMapping("/api/supervisor")
    public List<Supervisor> getAllSupervisor(){
        return supervisorRepository.findAll();
    }

    @GetMapping("/api/supervisor/{spv_id}")
    public Supervisor getSupervisor(@PathVariable ObjectId spv_id){
        return supervisorRepository.findBy_id(spv_id);
    }

    @PostMapping("/api/supervisor")
    public Supervisor addSupervisor(@Valid @RequestBody Supervisor supervisor){
        supervisor.set_id(ObjectId.get());

        return supervisorRepository.save(supervisor);
    }


}
