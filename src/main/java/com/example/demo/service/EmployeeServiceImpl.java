package com.example.demo.service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if (Objects.isNull(employee.getEmployeeId()) || employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    /**
     * @return
     */
    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Employee is not found by id: " + employeeId));
    }

    /**
     * @param employeeId
     */
    @Override
    public String deleteEmployeeById(String employeeId) {
        Employee employee = employeeList.stream()
                .filter(employee1 -> employee1.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow();
        employeeList.remove(employee);
        return "Employee is deleted by id: "+employeeId;
    }

}
