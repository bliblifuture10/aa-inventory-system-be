package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findById(String empId);
    List<Employee> findAllByNameContaining(String name);
    List<Employee> findAllBySupervisor(String spvId);

    boolean existsByIdEquals(String empId);
    boolean existsByNameContaining(String empName);
    boolean existsBySupervisorEquals(String spvId);

    Boolean deleteByIdEquals(String empId);
}
