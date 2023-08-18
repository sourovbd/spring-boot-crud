package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
@RequiredArgsConstructor
public class EmployeeV2Controller {

    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeId}")
    public Employee getById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping(value = "/{employeeId}")
    public String deleteById(@PathVariable String employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }
}
