package com.udemy.spring_basic.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.udemy.spring_basic.scope")
public class ScopeConfig {

}
