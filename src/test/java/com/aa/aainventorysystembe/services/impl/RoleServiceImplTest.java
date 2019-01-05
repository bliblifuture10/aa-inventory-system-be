package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.MockingObject.FakeObjectFactory;
import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.repositories.RoleRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.junit.Assert.*;

public class RoleServiceImplTest {

    @InjectMocks
    RoleServiceImpl roleService;

    @Mock
    RoleRepository roleRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("TearDown");
    }

    @Test
    public void getRole() {
        Role role = FakeObjectFactory.getFakeRole();
        when(roleRepository.existsByName(role.getName())).thenReturn(true);
        when(roleRepository.findByName(role.getName())).thenReturn(role);

        Role returned = roleService.getRole(role.getName());

        verify(roleRepository, times(1)).existsByName(role.getName());
        verify(roleRepository, times(1)).findByName(role.getName());

        assertEquals(role, returned);
    }
}