package com.example.gasWaterUsageMonitoring.convertor;

import com.example.gasWaterUsageMonitoring.dto.UserDto;
import com.example.gasWaterUsageMonitoring.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    private final ModelMapper modelMapper;

    public UserConverter() {
        this.modelMapper = new ModelMapper();
    }

    public UserDto convertToDto(User entity) {
        return modelMapper.map(entity, UserDto.class);
    }
}
