package com.green.paa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableFeignClients
@ConfigurationPropertiesScan
@SpringBootApplication
public class PaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaaApplication.class, args);
    }

}
