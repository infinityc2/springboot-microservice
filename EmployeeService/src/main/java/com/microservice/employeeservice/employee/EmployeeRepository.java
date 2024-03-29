package com.microservice.employeeservice.employee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

    List<Employee> findByPositionId(String positionId);
}