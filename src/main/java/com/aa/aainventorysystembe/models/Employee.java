package com.aa.aainventorysystembe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee extends User{
    private ObjectId supervisor;

    //Getter and Setter
    @JsonIgnore
    public String getSupervisor() {
        return supervisor.toHexString();
    }

    public void setSupervisor(ObjectId supervisor) {
        this.supervisor = supervisor;
    }
}
