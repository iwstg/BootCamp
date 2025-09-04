package com.udemy.spring_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // prototype으로 생성되면 스프링이 destroy를 해주지않음.
public class PrototypeNote {

    private static long segGen = 0L;
    private final long id = ++segGen;

    @PostConstruct
    public void init() {
        System.out.println("Prototype init 호출 [ " + id + " ]");
    }

    public void write(String msg){
        System.out.println("Prototype " + id + " " + msg);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("[ " + id + " ] Prototype destroy 호출");
    }

    // 직접 정리할 때 쓸 수 있는 메서드
    public void close() { destroy(); }
}
