package com.microservice.positionservice.position;

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
@RequestMapping("/positions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<Position> findPositionAll() {
        return positionService.findPositionAll();
    }

    @GetMapping("/{id}")
    public Position findPositionById(@PathVariable String id) {
        return positionService.findPositionById(id);
    }

    @PostMapping
    public Position addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @DeleteMapping("/{id}")
    public void deletePositionById(@PathVariable String id) {
        positionService.deletePositionById(id);
    }

    @PutMapping("/{id}")
    public Position updatePosition(@PathVariable String id, @RequestBody Position position) {
        return positionService.updatePosition(id, position);
    }
}