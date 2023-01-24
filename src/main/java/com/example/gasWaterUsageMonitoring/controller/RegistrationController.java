package com.example.gasWaterUsageMonitoring.controller;

import com.example.gasWaterUsageMonitoring.entity.User;
import com.example.gasWaterUsageMonitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("registration")
    public UUID registration(@Valid @RequestBody User user) {
        return userService.save(user).getId();
    }

}
