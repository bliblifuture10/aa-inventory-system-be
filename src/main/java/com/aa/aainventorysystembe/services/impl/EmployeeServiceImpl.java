package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.Employee;
import com.aa.aainventorysystembe.models.ErrorCode;
import com.aa.aainventorysystembe.models.Role;
import com.aa.aainventorysystembe.repositories.EmployeeRepository;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import com.aa.aainventorysystembe.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Employee> getEmployeeById(String empId) {
        if(!employeeRepository.existsByIdEquals(empId)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return employeeRepository.findById(empId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeeByName(String empName) {
        if(!employeeRepository.existsByNameContaining(empName)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }else{
            return employeeRepository.findAllByNameContaining(empName);
        }
    }

    @Override
    public List<Employee> getAllEmployeeBySupervisor(String spvId) {
        if(!employeeRepository.existsBySupervisorEquals(spvId)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }else{
            return employeeRepository.findAllBySupervisor(spvId);
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if(roleRepository.existsByName("employee")){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }else{
            Role role = roleRepository.findByName("employee");

            employee.setRole(role.getId());

            return employeeRepository.save(employee);
        }
    }

    @Override
    public Employee updateEmployee(Employee empId) {
        return null;
    }

    @Override
    public void deleteEmployee(String empId) {
        if(!employeeRepository.existsByIdEquals(empId)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }else{
            employeeRepository.deleteByIdEquals(empId);
        }
    }
}
