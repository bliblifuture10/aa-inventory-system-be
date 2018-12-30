package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.models.entity.Employee;
import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.repositories.EmployeeRepository;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import com.aa.aainventorysystembe.services.EmployeeService;
import com.aa.aainventorysystembe.services.RoleService;
import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

public class EmployeeServiceImplTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private Employee employee = Employee.builder()
            .supervisor("5bc19bf33740c32cff6cdc66")
            .build();


}
