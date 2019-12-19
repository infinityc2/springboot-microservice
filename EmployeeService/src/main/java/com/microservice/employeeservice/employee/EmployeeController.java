package com.microservice.employeeservice.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    public List<Employee> findEmployeeAll() {
        return employeeService.findEmployeeAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @GetMapping("/position/{positionId}")
    public List<Employee> findEmployeeByPositionId(@PathVariable String positionId) {
        return employeeService.findEmployeeByPositionId(positionId);
    }
}