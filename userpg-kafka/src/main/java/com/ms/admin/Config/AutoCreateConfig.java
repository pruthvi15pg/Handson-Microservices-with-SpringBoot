package com.ms.userpg.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoCreateConfig {

   @Value("${spring.kafka.topic}")
    public String topic;


   
}
