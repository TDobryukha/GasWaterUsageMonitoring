package com.example.gasWaterUsageMonitoring.repository;

import com.example.gasWaterUsageMonitoring.entity.Parameter;
import org.springframework.data.repository.CrudRepository;

public interface ParameterRepository extends CrudRepository<Parameter, String> {
}
