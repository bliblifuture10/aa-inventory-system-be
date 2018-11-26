package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);

    boolean existsByName(String name);
}
