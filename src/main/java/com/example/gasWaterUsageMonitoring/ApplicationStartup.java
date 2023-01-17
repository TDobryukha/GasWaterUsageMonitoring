package com.example.gasWaterUsageMonitoring;

import com.example.gasWaterUsageMonitoring.entity.Parameter;
import com.example.gasWaterUsageMonitoring.repository.ParameterRepository;
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

    @Autowired
    public ApplicationStartup(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {
        parameterRepository.save(new Parameter("gas"));
        parameterRepository.save(new Parameter("cold water"));
        parameterRepository.save(new Parameter("hot water"));
    }

}


