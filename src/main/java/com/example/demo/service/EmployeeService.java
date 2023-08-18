package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String employeeId);

    String deleteEmployeeById(String employeeId);
}
