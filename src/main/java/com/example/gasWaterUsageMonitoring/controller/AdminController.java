package com.example.gasWaterUsageMonitoring.controller;

import com.example.gasWaterUsageMonitoring.dto.MeasurementDto;
import com.example.gasWaterUsageMonitoring.entity.User;
import com.example.gasWaterUsageMonitoring.service.MeasurementService;
import com.example.gasWaterUsageMonitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
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
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("user/{id}")
    public Optional<User> findUserById(@PathVariable UUID id) {
        return userService.findById(id);
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
