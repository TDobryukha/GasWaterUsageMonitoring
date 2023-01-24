package com.example.gasWaterUsageMonitoring.dto;

import com.example.gasWaterUsageMonitoring.entity.Role;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String username;
    private Set<Role> roles;
}
