package com.aa.aainventorysystembe.MockingObject;

import com.aa.aainventorysystembe.models.entity.Employee;
import com.aa.aainventorysystembe.models.entity.Product;
import com.aa.aainventorysystembe.models.entity.Role;
import com.aa.aainventorysystembe.models.entity.Supervisor;

public class FakeObjectFactory {
    public static Employee getFakeEmployee()
    {
        Employee employee = new Employee();
        employee.setId("5c08c99ced8b771e3c93912e");
        employee.setName("Abdi Elman D. A.");
        employee.setEmail("abdielman99@gmail.com");
        employee.setUsername("reboot16");
        employee.setPassword("future10");
        employee.setPhone("082267414035");
        employee.setAddress("Balige");
        employee.setImage("lalalal.jpg");
        employee.setRole("5c08c920cf702b0079993c19");
        employee.setSupervisor("");

        return employee;
    }
    public static Employee getNewFakeEmployee()
    {
        Employee employee = new Employee();
        employee.setId("5c08c99ced8b771e3c93912e");
        employee.setName("Abdi");
        employee.setEmail("abdielman99@gmail.com");
        employee.setUsername("reboot16");
        employee.setPassword("future10");
        employee.setPhone("082267414035");
        employee.setAddress("Balige");
        employee.setImage("lalalal.jpg");
        employee.setRole("5c08c920cf702b0079993c19");
        employee.setSupervisor("");

        return employee;
    }


    public static Supervisor getFakeSupervisor()
    {
        Supervisor supervisor = new Supervisor();
        supervisor.setId("");


        return supervisor;
    }

    public static Role getFakeRole()
    {
        Role role = new Role();
        role.setId("5c08c920cf702b0079993c19");
        role.setName("employee");

        return role;
    }

    public static Product getFakeProduct()
    {
        Product product = new Product();
        product.setId("5c18786fea87eb2e34523588");
        product.setName("JBL Earphone x-121");
        product.setCategory("Electronic");
        product.setStock(34);
        product.setPrice(120000);
        product.setImage("Jbl");

        return product;
    }



}
