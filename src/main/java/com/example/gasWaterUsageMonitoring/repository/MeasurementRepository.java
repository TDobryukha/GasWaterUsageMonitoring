package com.example.gasWaterUsageMonitoring.repository;

import com.example.gasWaterUsageMonitoring.entity.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
    //List<Measurement> findAllByUserId(UUID uuid);
    List<Measurement> findAllByParameterName(String str);

    List<Measurement> findAllByUserId(UUID id);

}
