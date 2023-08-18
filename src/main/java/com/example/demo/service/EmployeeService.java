package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String employeeId);

    String deleteEmployeeById(String employeeId);
}
