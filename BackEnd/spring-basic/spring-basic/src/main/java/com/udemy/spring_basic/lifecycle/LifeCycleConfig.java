package com.udemy.spring_basic.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.udemy.spring_basic.lifecycle")
public class LifeCycleConfig {

    // init/destroy 메서드를 이름으로 등록
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public LifeCycleBeanWithConfiguration lifeCycleBeanWithConfiguration() {
        return new LifeCycleBeanWithConfiguration();
    }
}