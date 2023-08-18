package com.example.demo.service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeV2ServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * @param employee save employee
     * @return employee
     */
    @Override
    public Employee save(Employee employee) {
        if (Objects.isNull(employee.getEmployeeId()) || employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return employee;
    }

    /**
     * @return all employee
     */
    @Override
    public List<Employee> getAllEmployee() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();

        return employeeList.stream()
                .map(employeeEntity -> EmployeeEntity.entityToModel(employeeEntity))
                .collect(Collectors.toList());
    }

    /**
     * @param employeeId
     * @return
     */
    @Override
    public Employee getEmployeeById(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found by id: " + employeeId));

        return EmployeeEntity.entityToModel(employeeEntity);
    }

    /**
     * @param employeeId delete employe by employeeId
     * @return string message.
     */
    @Override
    public String deleteEmployeeById(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found by id: " + employeeId));
                //.orElseThrow();

        employeeRepository.delete(employeeEntity);
        //employeeRepository.deleteById(employeeId);
        return "Employee is deleted by id: " + employeeId;
    }
}
