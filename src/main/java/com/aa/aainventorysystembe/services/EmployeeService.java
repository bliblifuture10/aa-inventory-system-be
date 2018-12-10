package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee getEmployeeById(String empId);
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployeeByName(String empName);
    List<Employee> getAllEmployeeBySupervisor(String spvId);

    Employee createEmployee(Employee employee);
    Employee updateEmployeeById(String id, Employee employeeReq);
    Boolean deleteEmployeeById(String empId);
}
