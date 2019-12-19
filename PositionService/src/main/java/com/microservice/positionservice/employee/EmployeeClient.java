package com.microservice.positionservice.employee;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/employees/position/{positionId}")
    List<Employee> findEmployeeByPositionId(@PathVariable String positionId);
}