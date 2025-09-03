package com.udemy.spring_basic.config;

import com.udemy.spring_basic.repository.UsersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.udemy.spring_basic")
public class DuplicatedBeanScanAppConfig {

    @Bean(name = "userRepository")
    public UsersRepository usersRepository() {
        System.out.println("수동 등록");
        return new UsersRepository();
    }
}