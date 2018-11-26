package com.aa.aainventorysystembe.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    protected String role;
    protected String username;
    protected String password;
    protected String name;
    protected String email;
    protected String phone;
    protected String address;
    protected String image;
}
