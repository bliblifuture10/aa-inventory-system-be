package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.Supervisor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupervisorRepository extends MongoRepository<Supervisor, String> {
    Supervisor findBy_id(ObjectId spv_id);
}
