package com.microservice.employeeservice.employee;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Employee {

    @Id
    private String id;
    private String name;
    private int age;
    private String positionId;
}