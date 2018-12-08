package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.ErrorCode;
import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.models.entity.Supervisor;
import com.aa.aainventorysystembe.repositories.SupervisorRepository;
import com.aa.aainventorysystembe.services.RoleService;
import com.aa.aainventorysystembe.services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorServiceImpl implements SupervisorService {
    @Autowired
    SupervisorRepository supervisorRepository;

    @Autowired
    RoleService roleService;

    @Override
    public Optional<Supervisor> getSupervisorById(String spvId) {
        if(!supervisorRepository.existsById(spvId)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return supervisorRepository.findById(spvId);
    }

    @Override
    public List<Supervisor> getAllSupervisor() {
        return supervisorRepository.findAll();
    }

    @Override
    public List<Supervisor> getAllSupervisorByName(String name) {
        return supervisorRepository.findAllByName(name);
    }

    @Override
    public Supervisor createSupervisor(Supervisor supervisor) {
        Role role = roleService.getRole("supervisor");

        supervisor.setRole(role.getId());

        return supervisorRepository.save(supervisor);
    }

    @Override
    public Supervisor updateSupervisor(Supervisor supervisor) {
        return null;
    }

    @Override
    public void deleteSupervisor(String spvId) {
        if(!supervisorRepository.existsById(spvId)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        supervisorRepository.deleteById(spvId);
    }
}
