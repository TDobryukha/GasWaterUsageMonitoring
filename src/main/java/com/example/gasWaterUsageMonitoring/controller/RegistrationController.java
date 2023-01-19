package com.example.gasWaterUsageMonitoring.controller;

import com.example.gasWaterUsageMonitoring.entity.User;
import com.example.gasWaterUsageMonitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("api/user")
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

    @GetMapping("find")
    public Optional<User> findUserById(@RequestParam UUID id) {
        return userService.findById(id);
    }

    @GetMapping("findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
}
