package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Employee;
import com.aa.aainventorysystembe.models.Role;
import com.aa.aainventorysystembe.repositories.EmployeeRepository;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/api/employee")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @GetMapping("/api/employee/{emp_id}")
    public Employee getAllEmployee(@PathVariable ObjectId emp_id){
        return employeeRepository.findBy_id(emp_id);
    }

    @PostMapping("/api/employee")
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        Role role;
        role = roleRepository.findByName("employee");

        employee.set_id(ObjectId.get());
        employee.setRole(role.get_id());

        return employeeRepository.save(employee);
    }

}
