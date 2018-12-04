package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.entity.Employee;
import com.aa.aainventorysystembe.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //GET
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/id/{empId}")
    public Optional<Employee> getEmployee(@PathVariable String empId){
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/name/{empName}")
    public List<Employee> getEmployeeByName(@PathVariable String empName){
        return employeeService.getAllEmployeeByName(empName);
    }

    @GetMapping("/supervisor/{spvId}")
    public List<Employee> getEmployeeBySupervisor(@PathVariable String spvId){
        return employeeService.getAllEmployeeBySupervisor(spvId);
    }

    //CRUD
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

//    @PutMapping("/id/{emp_id}")
//    public Employee updateEmployee(@PathVariable String emp_id, @Valid @RequestBody Employee employee){
//
//    }

    @DeleteMapping("/id/{empId}")
    public void deleteEmployee(@PathVariable String empId){
        employeeService.deleteEmployee(empId);
    }

}
