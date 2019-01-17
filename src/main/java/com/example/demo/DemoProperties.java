package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.demo")
// Ini untuk bind external configurations
// prefix nya itu buat prefix yang ada di file *.properties, ex: com.demo.restApiBasePath
@Data
public class DemoProperties {
    private String restApiBasePath;
    private String graphqlApiBasePath;
}
