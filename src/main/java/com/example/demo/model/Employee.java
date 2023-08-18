package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
//@JsonIgnoreProperties({"department", "employeeId"})
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
    //@JsonIgnore
    private String department;
}
