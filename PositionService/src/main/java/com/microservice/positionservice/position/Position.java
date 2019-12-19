package com.microservice.positionservice.position;

import java.util.List;

import javax.persistence.Id;

import com.microservice.positionservice.employee.Employee;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Position {

    @Id
    private String id;

    private String name;

    private List<Employee> employees;
}