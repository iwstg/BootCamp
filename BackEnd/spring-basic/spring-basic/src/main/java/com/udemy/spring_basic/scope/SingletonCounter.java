package com.udemy.spring_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component // 기본 스코프: 싱글톤
public class SingletonCounter {

    private int count = 0;

    @PostConstruct
    void init() {
        System.out.println("Singleton] init 호출");
    }

    public int next() {
        return ++count;
    }

    @PreDestroy
    void destroy() {
        System.out.println("Singleton destroy 호출");
    }
}