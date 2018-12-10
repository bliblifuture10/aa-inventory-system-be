package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.entity.Employee;
import com.aa.aainventorysystembe.models.ErrorCode;
import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.repositories.EmployeeRepository;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import com.aa.aainventorysystembe.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorCode.NOT_FOUND.getCode(),
                        ErrorCode.NOT_FOUND.getMessage()
                ));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeeByName(String name) {
        if(!employeeRepository.existsByNameContaining(name)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }else{
            return employeeRepository.findAllByNameContaining(name);
        }
    }

    @Override
    public List<Employee> getAllEmployeeBySupervisor(String id) {
        if(!employeeRepository.existsBySupervisorEquals(id)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }else{
            return employeeRepository.findAllBySupervisor(id);
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if(!roleRepository.existsByName("employee")){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }else{
            Role role = roleRepository.findByName("employee");

            employee.setRole(role.getId());

            return employeeRepository.save(employee);
        }
    }

    @Override
    public Employee updateEmployeeById(String id, Employee employeeReq) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setSupervisor(employeeReq.getSupervisor());
            employee.setName(employeeReq.getName());
            employee.setEmail(employeeReq.getEmail());
            employee.setPhone(employeeReq.getPhone());
            employee.setAddress(employeeReq.getAddress());
            employee.setImage(employeeReq.getImage());

            return employeeRepository.save(employee);
        }).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.NOT_FOUND.getCode(),
                ErrorCode.NOT_FOUND.getMessage()
        ));
    }

    @Override
    public Boolean deleteEmployeeById(String id) {
        if(!employeeRepository.existsByIdEquals(id)){
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return employeeRepository.deleteByIdEquals(id);
    }
}
