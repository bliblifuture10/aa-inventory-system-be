package com.aa.aainventorysystembe.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Employee extends User{
    private String supervisor;

    public Employee(String supervisor) {
        this.supervisor = supervisor;
    }

    public Employee(String id, String role, String username, String password, String name, String email, String phone, String address, String image, String supervisor) {
        super(id, role, username, password, name, email, phone, address, image);
        this.supervisor = supervisor;
    }
}
