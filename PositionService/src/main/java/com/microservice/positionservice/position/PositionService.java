package com.microservice.positionservice.position;

import java.util.List;
import java.util.Optional;

import com.microservice.positionservice.employee.EmployeeClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    private PositionRepository positionRepository;
    private EmployeeClient employeeClient;

    @Autowired
    public PositionService(PositionRepository positionRepository, EmployeeClient employeeClient) {
        this.positionRepository = positionRepository;
        this.employeeClient = employeeClient;
    }

    public List<Position> findPositionAll() {
        return positionRepository.findAll();
    }

    @HystrixCommand(fallbackMethod = "")
    public Position findPositionById(String id) {
        Optional<Position> position = positionRepository.findById(id);
        position.ifPresent(p -> {
            p.setEmployees(employeeClient.findEmployeeByPositionId(p.getId()));
        });
        return position.get();
    }

    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }

    public void deletePositionById(String id) {
        positionRepository.deleteById(id);
    }

    public Position updatePosition(String id, Position position) {
        positionRepository.findById(id).ifPresent(p -> position.setId(p.getId()));
        return positionRepository.save(position);
    }

    public String defaultFallBack(String id) {
        return id;
    }

}