package com.osstem.ow.eci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class EciApplication {

    public static void main(String[] args) {
        SpringApplication.run(EciApplication.class, args);
    }

}
