package com.example.gasWaterUsageMonitoring.controller;

import com.example.gasWaterUsageMonitoring.dto.MeasurementDto;
import com.example.gasWaterUsageMonitoring.dto.UserDto;
import com.example.gasWaterUsageMonitoring.exception.NotFoundException;
import com.example.gasWaterUsageMonitoring.service.MeasurementService;
import com.example.gasWaterUsageMonitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final UserService userService;
    private final MeasurementService measurementService;

    @Autowired
    public AdminController(UserService userService, MeasurementService measurementService) {
        this.userService = userService;
        this.measurementService = measurementService;
    }

    @GetMapping("user")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("user/{id}/history")
    public List<MeasurementDto> printHistory(@PathVariable UUID id) {
        return measurementService.findAllByUser(id);
    }

    @GetMapping("measurements/{name}")
    public List<MeasurementDto> findAllByParameter(@PathVariable String name) {
        return measurementService.findAllByParameterName(name);
    }
}
