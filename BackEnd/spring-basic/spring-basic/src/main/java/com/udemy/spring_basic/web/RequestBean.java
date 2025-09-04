package com.udemy.spring_basic.web;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.val;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
// @Scope("request") // 요청이 와야 실행이 되는건데, 스프링이 실행할때 생성하려고하면서 에러남. provider를 사용해 해결.
public class RequestBean {

    private String value;
    public RequestBean() {
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
