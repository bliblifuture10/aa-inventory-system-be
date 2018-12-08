package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.entity.Supervisor;

import java.util.List;
import java.util.Optional;

public interface SupervisorService {
    Optional<Supervisor> getSupervisorById(String spvId);
    List<Supervisor> getAllSupervisor();
    List<Supervisor> getAllSupervisorByName(String name);

    Supervisor createSupervisor(Supervisor supervisor);
    Supervisor updateSupervisor(Supervisor supervisor);
    void deleteSupervisor(String spvId);
}
