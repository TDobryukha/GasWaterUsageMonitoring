package com.example.gasWaterUsageMonitoring.service;

import com.example.gasWaterUsageMonitoring.entity.Measurement;
import com.example.gasWaterUsageMonitoring.entity.Parameter;
import com.example.gasWaterUsageMonitoring.entity.User;
import com.example.gasWaterUsageMonitoring.exception.NotFoundException;
import com.example.gasWaterUsageMonitoring.repository.MeasurementRepository;
import com.example.gasWaterUsageMonitoring.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final ParameterRepository parameterRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, ParameterRepository parameterRepository) {
        this.measurementRepository = measurementRepository;
        this.parameterRepository = parameterRepository;
    }

    public Measurement save(Measurement measurement, User user) {
        measurement.setUser(user);
        Parameter parameter = parameterRepository.findById(measurement.getParameter().getName().toLowerCase()).orElseThrow(() -> new NotFoundException("Parameter not found: " + measurement.getParameter().getName()));
        measurement.setParameter(parameter);
        return measurementRepository.save(measurement);
    }

    public List<Measurement> findAllByUser(UUID id) {
        return measurementRepository.findAllByUserId(id);
    }

}
