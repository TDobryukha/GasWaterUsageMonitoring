package com.example.gasWaterUsageMonitoring.repository;

import com.example.gasWaterUsageMonitoring.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
