package com.example.gasWaterUsageMonitoring.convertor;

import com.example.gasWaterUsageMonitoring.dto.MeasurementDto;
import com.example.gasWaterUsageMonitoring.entity.Measurement;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MeasurementConverter {
    private final ModelMapper modelMapper;

    public MeasurementConverter() {
        this.modelMapper = new ModelMapper();
    }

    public MeasurementDto convertToDto(Measurement entity) {
        return modelMapper.map(entity, MeasurementDto.class);
    }
}
