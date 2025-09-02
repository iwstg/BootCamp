package com.udemy.spring_basic.singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CautionSingletonDemo {
    public static void main(String[] args) {
        var ac = new AnnotationConfigApplicationContext(CautionConfiguration.class);
        var sc1 = ac.getBean("singletonCautionService", SingletonCautionService.class);
        var sc2 = ac.getBean("singletonCautionService", SingletonCautionService.class);
        System.out.println("[DEMO] 같은 빈? " + (sc1==sc2));

        sc1.order(1000); // A 사용자의 주문
        sc2.order(2000); // B 사용자의 주문(같은 빈 인스턴스에 덮어씀)

        System.out.println("[DEMO] A가 기대하는 값=1000, 실제=" + sc1.getOrder());
        System.out.println("[DEMO] B가 기대하는 값=2000, 실제=" + sc2.getOrder());

    }
}
