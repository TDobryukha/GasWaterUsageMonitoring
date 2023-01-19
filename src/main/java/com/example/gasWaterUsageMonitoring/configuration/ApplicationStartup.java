package com.example.gasWaterUsageMonitoring.configuration;

import com.example.gasWaterUsageMonitoring.entity.Parameter;
import com.example.gasWaterUsageMonitoring.entity.Role;
import com.example.gasWaterUsageMonitoring.repository.ParameterRepository;
import com.example.gasWaterUsageMonitoring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */

    private final ParameterRepository parameterRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public ApplicationStartup(ParameterRepository parameterRepository, RoleRepository roleRepository) {
        this.parameterRepository = parameterRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {
        parameterRepository.save(new Parameter("gas"));
        parameterRepository.save(new Parameter("cold water"));
        parameterRepository.save(new Parameter("hot water"));
        roleRepository.save(new Role("ROLE_USER"));
        roleRepository.save(new Role("ROLE_ADMIN"));
    }

}


