package com.udemy.spring_basic.web;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Component
@Scope("request")
public class RequestProviderBean {
    private String value;
    public RequestProviderBean() {
        this.value = UUID.randomUUID().toString();
    }

    public String getValue() {
        return value;
    }

    @PostConstruct
    public void init() {
        System.out.println("RequestBean 생성 " + value);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("RequestBean 소멸 " + value);
    }
}

