package com.udemy.spring_basic.lifecycle;

public class LifeCycleBeanWithConfiguration {

    public LifeCycleBeanWithConfiguration() {
        System.out.println("생성자 호출: LifeCycleBeanWithConfiguration 객체 생성");
    }

    // 초기화 로직
    public void init() {
        System.out.println("init 호출: 빈 초기화 작업 실행");
    }

    // 소멸(정리) 로직
    public void destroy() {
        System.out.println("destroy 호출: 빈 자원 정리 작업 실행");
    }

    // 비즈니스 메서드(아무 출력)
    public void doSomething() {
        System.out.println("doSomething() 실행: 비즈니스 로직 수행");
    }
}