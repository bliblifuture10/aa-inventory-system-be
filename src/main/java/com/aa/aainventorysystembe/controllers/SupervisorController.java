package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.repositories.RoleRepository;
import com.aa.aainventorysystembe.repositories.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supervisor")
public class SupervisorController {
    @Autowired
    SupervisorRepository supervisorRepository;

    @Autowired
    RoleRepository roleRepository;

//    //GET
//    @GetMapping("")
//    public List<Supervisor> getAllSupervisor(){
//        return supervisorRepository.findAll();
//    }
//
//    @GetMapping("/id/{spv_id}")
//    public Supervisor getSupervisor(@PathVariable String spv_id){
//        return supervisorRepository.findByIdEquals(spv_id);
//    }
//
//    @GetMapping("/name/{name}")
//    public List<Supervisor> getSupervisorByName(@PathVariable String name){
//        if (!supervisorRepository.existsByNameContaining(name)) {
//            throw new ResourceNotFoundException("No results for supervisor named " + name);
//        }
//
//        return supervisorRepository.findAllByNameEquals(name);
//    }
//
//    //CRUD
//    @PostMapping("")
//    public Supervisor addSupervisor(@Valid @RequestBody Supervisor supervisor){
//        Role role = roleRepository.findByNameEquals("supervisor");
//
//        supervisor.setRole(role.get_id());
//
//        return supervisorRepository.save(supervisor);
//    }
//
//    @PutMapping("/id/{spv_id}")
//    public Supervisor updateSupervisor(@PathVariable String spv_id, @Valid @RequestBody Supervisor supervisor){
//        if (!supervisorRepository.existsByIdEquals(spv_id)) {
//            throw new ResourceNotFoundException("Supervisor with id " + spv_id + " not found");
//        }
//
//        supervisor.setId(spv_id);
//
//        return supervisorRepository.save(supervisor);
//    }
//
//    @DeleteMapping("/id/{spv_id}")
//    public boolean deleteSupervisor(@PathVariable String spv_id){
//        if (!supervisorRepository.existsByIdEquals(spv_id)) {
//            throw new ResourceNotFoundException("Supervisor with id " + spv_id + " not found");
//        }
//
//        return supervisorRepository.deleteByIdEquals(spv_id);
//    }

}
