package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.Employee;
import com.aa.aainventorysystembe.models.Role;
import com.aa.aainventorysystembe.repositories.EmployeeRepository;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    //GET
    @GetMapping("")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @GetMapping("/id/{emp_id}")
    public Employee getEmployee(@PathVariable String emp_id){
        if(!employeeRepository.existsBy_id(emp_id)){
            throw new ResourceNotFoundException("Employee with id " + emp_id + " not found");
        }

        return employeeRepository.findBy_id(emp_id);
    }

    @GetMapping("/name/{emp_name}")
    public List<Employee> getEmployeeByName(@PathVariable String emp_name){
        if(!employeeRepository.existsByNameContaining(emp_name)){
            throw new ResourceNotFoundException("No results for employee named " + emp_name);
        }

        return employeeRepository.findAllByNameContaining(emp_name);
    }

    @GetMapping("/supervisor/{spv_id}")
    public List<Employee> getEmployeeBySupervisor(@PathVariable String spv_id){
        return employeeRepository.findAllBySupervisor(spv_id);
    }

    //CRUD
    @PostMapping("")
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        Role role = roleRepository.findByName("employee");

        employee.setRole(role.get_id());

        return employeeRepository.save(employee);
    }

    @PutMapping("/id/{emp_id}")
    public Employee updateEmployee(@PathVariable String emp_id, @Valid @RequestBody Employee employee){
        if(!employeeRepository.existsBy_id(emp_id)){
            throw new ResourceNotFoundException("Employee with " + emp_id + " not found");
        }

        employee.set_id(emp_id);

        return employeeRepository.save(employee);
    }

    @DeleteMapping("/id/{emp_id}")
    public boolean deleteEmployee(@PathVariable String emp_id){
        if(!employeeRepository.existsBy_id(emp_id)){
            throw new ResourceNotFoundException("Employee with " + emp_id + " not found");
        }

        return employeeRepository.deleteBy_id(emp_id);
    }

}
