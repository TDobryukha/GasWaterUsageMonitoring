package com.example.gasWaterUsageMonitoring.service;

import com.example.gasWaterUsageMonitoring.entity.Role;
import com.example.gasWaterUsageMonitoring.entity.User;
import com.example.gasWaterUsageMonitoring.repository.RoleRepository;
import com.example.gasWaterUsageMonitoring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
    }

    public User save(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return null;
        }
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singleton(role));
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + username);
        }

        return user;
    }
}
