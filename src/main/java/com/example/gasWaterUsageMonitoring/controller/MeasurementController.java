package com.example.gasWaterUsageMonitoring.controller;

import com.example.gasWaterUsageMonitoring.entity.Measurement;
import com.example.gasWaterUsageMonitoring.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/measurement")
public class MeasurementController {
    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("add")
    public String addMeasurement(@Valid @RequestBody Measurement measurement) {
        measurement.getParameter().setName(measurement.getParameter().getName().toLowerCase());
        long result = measurementService.save(measurement).getId();
        return "{\"id\": " + result + "}";
    }

    @GetMapping("history")
    public List<Measurement> printHistory(@Valid @RequestParam UUID id) {
        return measurementService.findAllByUser(id);

    }

}
