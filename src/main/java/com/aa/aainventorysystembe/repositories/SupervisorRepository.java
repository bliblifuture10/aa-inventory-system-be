package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.Supervisor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupervisorRepository extends MongoRepository<Supervisor, String> {
    Supervisor findBy_id(String spv_id);
    List<Supervisor> findAllByName(String name);

    boolean existsBy_id(String spv_id);
    boolean existsByNameContaining(String name);

    boolean deleteBy_id(String spv_id);
}
