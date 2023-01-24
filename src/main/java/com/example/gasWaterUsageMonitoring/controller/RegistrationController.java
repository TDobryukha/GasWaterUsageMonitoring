package com.example.gasWaterUsageMonitoring.controller;

import com.example.gasWaterUsageMonitoring.entity.User;
import com.example.gasWaterUsageMonitoring.exception.UserAlreadyExists;
import com.example.gasWaterUsageMonitoring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class RegistrationController {
    private final UserService userService;

    @PostMapping("registration")
    public ResponseEntity<UUID> registration(@Valid @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.save(user).getId());
        } catch (UserAlreadyExists e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
