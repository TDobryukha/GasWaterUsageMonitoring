package com.example.gasWaterUsageMonitoring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MeasurementDto {
    private Long id;
    private String userName;
    private String parameterName;
    private double value;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
