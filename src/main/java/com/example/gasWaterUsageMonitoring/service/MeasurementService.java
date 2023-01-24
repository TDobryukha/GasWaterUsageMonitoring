package com.example.gasWaterUsageMonitoring.service;

import com.example.gasWaterUsageMonitoring.convertor.MeasurementConverter;
import com.example.gasWaterUsageMonitoring.dto.MeasurementDto;
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
import java.util.stream.Collectors;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final ParameterRepository parameterRepository;
    private final MeasurementConverter measurementConverter;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, ParameterRepository parameterRepository) {
        this.measurementRepository = measurementRepository;
        this.parameterRepository = parameterRepository;
        this.measurementConverter = new MeasurementConverter();
    }

    public Measurement save(Measurement measurement, User user) {
        measurement.setUser(user);
        Parameter parameter = parameterRepository.findById(measurement.getParameter().getName().toLowerCase()).orElseThrow(() -> new NotFoundException("Parameter not found: " + measurement.getParameter().getName()));
        measurement.setParameter(parameter);
        return measurementRepository.save(measurement);
    }

    public List<MeasurementDto> findAllByUser(UUID id) {
        return measurementRepository.findAllByUserId(id)
                .stream()
                .map(measurementConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public List<MeasurementDto> findAllByParameterName(String parameterName) {
        return measurementRepository.findAllByParameterName(parameterName.toLowerCase())
                .stream()
                .map(measurementConverter::convertToDto)
                .collect(Collectors.toList());
    }

}
