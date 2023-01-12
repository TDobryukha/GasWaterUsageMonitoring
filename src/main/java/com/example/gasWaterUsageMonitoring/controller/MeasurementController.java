package com.example.gasWaterUsageMonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.gasWaterUsageMonitoring.service.MeasurementService;

@RestController
public class MeasurementController {
    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

//    @PostMapping("add")
//    public void addMeasurement()

}
