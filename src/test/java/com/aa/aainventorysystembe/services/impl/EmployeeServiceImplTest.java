package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.MockingObject.FakeObjectFactory;
import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.entity.Employee;
import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.repositories.EmployeeRepository;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import com.aa.aainventorysystembe.services.EmployeeService;
import com.aa.aainventorysystembe.services.RoleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private RoleService roleService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
        System.out.println("Running : TearDown");
    }
    @Test
    public void getAllEmployee()
    {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(Employee.builder().supervisor("234567543").build(),
                    Employee.builder().supervisor("34565432123456").build()));
        List<Employee> employeess = employeeServiceImpl.getAllEmployee();

        verify(employeeRepository, times(1)).findAll();
        assertEquals(employeess, employeeRepository.findAll());

    }

    @Test
    public void getEmployeeById() {

        Employee employee = FakeObjectFactory.getFakeEmployee();
        String id = employee.getId();
        when(employeeRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(employee));

        Employee returned = employeeServiceImpl.getEmployeeById(id);


        verify(employeeRepository, times(1)).findById(id);//verify(employeeRepository);

        assertEquals(employee, returned);
    }

    @Test
    public void deleteEmployeById() throws ResourceNotFoundException
    {
        Employee employee = FakeObjectFactory.getFakeEmployee();

        when(employeeRepository.existsByIdEquals(employee.getId())).thenReturn(true);

        boolean status = employeeServiceImpl.deleteEmployeeById(employee.getId());
        verify(employeeRepository, times(1)).existsByIdEquals(employee.getId());
        assertEquals(status, employeeRepository.deleteByIdEquals(employee.getId()));
    }

    @Test
    public void getEmployeeByName()
    {
        Employee employee = FakeObjectFactory.getFakeEmployee();
        String name = employee.getName();
        when(employeeRepository.existsByNameContaining(name)).thenReturn(true);
        List<Employee> returned = employeeServiceImpl.getAllEmployeeByName(name);

        verify(employeeRepository, times(1)).findAllByNameContaining(name);

        assertEquals(employeeRepository.findAllByNameContaining(name), returned);
    }

    @Test
    public void createEmployee()
    {
        Employee employee = FakeObjectFactory.getFakeEmployee();
        Role role = FakeObjectFactory.getFakeRole();

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        when(roleService.getRole("employee")).thenReturn(role);
        Employee returned = employeeServiceImpl.createEmployee(employee,employee.getImage());

        verify(employeeRepository, times(1)).save(employee);
        verify(roleService, times(1)).getRole("employee");
        assertEquals(employee, returned);
    }

    @Test
    public void updateEmployeeById()
    {
        Employee old = FakeObjectFactory.getFakeEmployee();
        Employee upd = FakeObjectFactory.getNewFakeEmployee();

        when(employeeRepository.findById(old.getId())).thenReturn(java.util.Optional.ofNullable(old));
        when(employeeRepository.save(any(Employee.class))).thenReturn(upd);

        Employee rtrn = employeeServiceImpl.updateEmployeeById(old.getId(), upd, upd.getImage());

        verify(employeeRepository, times(1)).findById(old.getId());
        verify(employeeRepository, times(1)).save(upd);

        assertEquals(rtrn, upd);

    }






}
