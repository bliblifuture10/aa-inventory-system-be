package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.entity.Supervisor;

import java.util.List;
import java.util.Optional;

public interface SupervisorService {
    Supervisor getSupervisorById(String spvId);
    List<Supervisor> getAllSupervisor();
    List<Supervisor> getAllSupervisorByName(String name);

    Supervisor createSupervisor(Supervisor supervisor);
    Supervisor updateSupervisorById(String id, Supervisor supervisorReq);
    Boolean deleteSupervisorById(String spvId);
}
