package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tbl_employee")
public class EmployeeEntity {

    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String department;
}
