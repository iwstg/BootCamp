package com.udemy.spring_basic.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RuninitDestroyConfigDemo {
    public static void main(String[] args) {
        // try-with-resources로 컨텍스트 자동 close → destroy 호출 보장
        try (AnnotationConfigApplicationContext ac =
                     new AnnotationConfigApplicationContext(LifeCycleConfig.class)) {

            LifeCycleBeanWithConfiguration bean =
                    ac.getBean(LifeCycleBeanWithConfiguration.class);

            bean.doSomething();
        }
        // try-with-resources 블록을 벗어나면 ac.close() 호출 → destroy() 로그 출력
    }
}