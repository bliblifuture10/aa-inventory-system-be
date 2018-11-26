package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> getEmployeeById(String empId);
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployeeByName(String empName);
    List<Employee> getAllEmployeeBySupervisor(String spvId);

    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(String empId);
}
