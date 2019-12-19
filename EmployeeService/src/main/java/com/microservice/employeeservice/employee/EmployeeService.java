package com.microservice.employeeservice.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findEmployeeById(String id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findEmployeeAll() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeById(String id, Employee employee) {
        employeeRepository.findById(id).ifPresent(e -> employee.setId(e.getId()));
        return employeeRepository.save(employee);
    }

    public List<Employee> findEmployeeByPositionId(String positionId) {
        return employeeRepository.findByPositionId(positionId);
    }
}