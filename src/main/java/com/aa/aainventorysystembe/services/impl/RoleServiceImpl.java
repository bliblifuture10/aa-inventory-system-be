package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.ErrorCode;
import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import com.aa.aainventorysystembe.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRole(String name) {
        if(!roleRepository.existsByName(name)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return roleRepository.findByName(name);
    }
}
