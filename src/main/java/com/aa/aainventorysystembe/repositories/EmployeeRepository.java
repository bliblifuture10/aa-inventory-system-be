package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findBy_id(String emp_id);
    List<Employee> findAllByNameContaining(String name);
    List<Employee> findAllBySupervisor(String spv_id);

    boolean existsBy_id(String emp_id);
    boolean existsByUsernameEquals(String emp_username);
    boolean existsByNameContaining(String emp_name);

    boolean deleteBy_id(String emp_id);
}
