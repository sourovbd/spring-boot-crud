package com.example.demo.entity;

import com.example.demo.model.Employee;
import lombok.Data;
import org.springframework.beans.BeanUtils;
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

    public static Employee entityToModel(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }
}
