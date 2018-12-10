package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.entity.Supervisor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SupervisorRepository extends MongoRepository<Supervisor, String> {
    Optional<Supervisor> findById(String spvId);
    List<Supervisor> findAllByName(String name);

    boolean existsById(String spvId);
    boolean existsByNameContaining(String name);

    Boolean deleteByIdEquals(String spvId);
}
