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
    public Supervisor getSupervisorById(String spvId) {
        return supervisorRepository.findById(spvId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorCode.NOT_FOUND.getCode(),
                        ErrorCode.NOT_FOUND.getMessage())
                );
    }

    @Override
    public List<Supervisor> getAllSupervisor() {
        return supervisorRepository.findAll();
    }

    @Override
    public List<Supervisor> getAllSupervisorByName(String name) {
        return supervisorRepository.findAllByNameContaining(name);
    }

    @Override
    public Supervisor createSupervisor(Supervisor supervisor, String imageValue) {
        Role role = roleService.getRole("supervisor");

        supervisor.setRole(role.getId());
        supervisor.setImage("/images/supervisors/" + imageValue);

        return supervisorRepository.save(supervisor);
    }

    @Override
    public Supervisor updateSupervisorById(String id, Supervisor supervisorReq, String imageValue) {
        return supervisorRepository.findById(id).map(supervisor -> {
            supervisor.setName(supervisorReq.getName());
            supervisor.setEmail(supervisorReq.getEmail());
            supervisor.setPhone(supervisorReq.getPhone());
            supervisor.setAddress(supervisorReq.getAddress());
            if(imageValue != null){
                supervisor.setImage("/images/supervisors/" + imageValue);
            }

            return supervisorRepository.save(supervisor);
        }).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.NOT_FOUND.getCode(),
                ErrorCode.NOT_FOUND.getMessage()
        ));
    }

    @Override
    public Boolean deleteSupervisorById(String spvId) {
        if(!supervisorRepository.existsById(spvId)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return supervisorRepository.deleteByIdEquals(spvId);
    }
}
