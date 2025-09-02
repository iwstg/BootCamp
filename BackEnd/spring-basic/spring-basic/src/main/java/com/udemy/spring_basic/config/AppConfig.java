package com.udemy.spring_basic.config;

import com.udemy.spring_basic.repository.UsersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UsersRepository usersRepository() {
        return new UsersRepository();
    }
}