package com.udemy.spring_basic.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CautionConfiguration {

    @Bean
    public SingletonCautionService singletonCautionService(){
        return new SingletonCautionService();
    }
}
