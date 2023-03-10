package com.example.gasWaterUsageMonitoring.controller;

import com.example.gasWaterUsageMonitoring.dto.MeasurementDto;
import com.example.gasWaterUsageMonitoring.entity.Measurement;
import com.example.gasWaterUsageMonitoring.entity.User;
import com.example.gasWaterUsageMonitoring.exception.NotFoundException;
import com.example.gasWaterUsageMonitoring.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/measurement")
public class MeasurementController {
    private final MeasurementService measurementService;

    @PostMapping("add")
    public ResponseEntity<String> addMeasurement(@Valid @RequestBody Measurement measurement, @AuthenticationPrincipal User user) {
        try {
            long result = measurementService.save(measurement, user).getId();
            return new ResponseEntity<>("{\"id\": " + result + "}", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("history")
    public List<MeasurementDto> printHistory(@AuthenticationPrincipal User user) {
        return measurementService.findAllByUser(user.getId());
    }
}
