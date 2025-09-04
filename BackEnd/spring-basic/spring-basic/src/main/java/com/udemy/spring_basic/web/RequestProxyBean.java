package com.udemy.spring_basic.web;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 프록시 적용
public class RequestProxyBean {

    private final String value = UUID.randomUUID().toString();

    public String getValue() {
        return value;
    }

    @PostConstruct
    public void init() {
        System.out.println("[RequestProxyBean 생성] value=" + value);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[RequestProxyBean 소멸] value=" + value);
    }
}