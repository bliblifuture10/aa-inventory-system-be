package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findBy_id(ObjectId emp_id);
    Employee findByName(String name);
}
