package com.example.gasWaterUsageMonitoring.repository;

import com.example.gasWaterUsageMonitoring.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
