package com.example.gasWaterUsageMonitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gasWaterUsageMonitoring.repository.MeasurementRepository;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

}
