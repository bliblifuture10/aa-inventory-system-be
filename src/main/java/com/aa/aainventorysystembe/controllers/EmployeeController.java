package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Response;
import com.aa.aainventorysystembe.models.entity.Employee;
import com.aa.aainventorysystembe.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController extends GlobalController{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Response<List<Employee>> getAllEmployee(){
        return toResponse(employeeService.getAllEmployee());
    }

    @GetMapping("/id/{id}")
    public Response<Employee> getEmployeeById(@PathVariable String id){
        return toResponse(employeeService.getEmployeeById(id));
    }

    @GetMapping("/name/{name}")
    public Response<List<Employee>> getEmployeeByName(@PathVariable String name){
        return toResponse(employeeService.getAllEmployeeByName(name));
    }

    @GetMapping("/supervisor/{id}")
    public Response<List<Employee>> getEmployeeBySupervisor(@PathVariable String id){
        return toResponse(employeeService.getAllEmployeeBySupervisor(id));
    }

    @PostMapping
    public Response<Employee> addEmployee(
            @RequestParam MultipartFile file,
            @Valid @ModelAttribute Employee employee
    ){
        String imageValue = null;

        try{
            imageValue = saveUploadedFiles(file, "employees");
        }catch (IOException e){}

        return toResponse(employeeService.createEmployee(employee, imageValue));
    }

    @PutMapping("/id/{id}")
    public Response<Employee> updateEmployee(
            @PathVariable String id,
            @RequestParam MultipartFile file,
            @Valid @ModelAttribute Employee employeeReq
    ){
        String imageValue = null;

        try{
            imageValue = saveUploadedFiles(file, "employees");
        }catch (IOException e){}

        return toResponse(employeeService.updateEmployeeById(id, employeeReq, imageValue));
    }

    @DeleteMapping("/id/{id}")
    public Response<Boolean> deleteEmployee(@PathVariable String id){
        return toResponse(employeeService.deleteEmployeeById(id));
    }

}
