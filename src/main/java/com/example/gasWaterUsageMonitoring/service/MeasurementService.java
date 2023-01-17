package com.example.gasWaterUsageMonitoring.service;

import com.example.gasWaterUsageMonitoring.entity.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gasWaterUsageMonitoring.repository.MeasurementRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public Measurement save(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public List<Measurement> findAllByUser(UUID id) {
        return measurementRepository.findAllByUserId(id);
    }


}
