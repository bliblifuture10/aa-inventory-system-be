package com.aa.aainventorysystembe.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Supervisor extends User{

    public Supervisor() {}

    public Supervisor(String id, String role, String username, String password, String name, String email, String phone, String address, String image) {
        super(id, role, username, password, name, email, phone, address, image);
    }
}
