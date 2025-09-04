package com.udemy.spring_basic.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ScopeMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ScopeConfig.class);

        System.out.println("===    싱글톤 스코프    ===");
        SingletonCounter c1 = ac.getBean(SingletonCounter.class);
        SingletonCounter c2 = ac.getBean(SingletonCounter.class);
        System.out.println("c1 == c2 ? " + (c1 == c2)); // 컨테이너가 동일하여 같은 싱글톤임.
        System.out.println("count = " + c1.next()); // c1의 next로 count값을 ++ 시키고 출력함. ( 1 )
        System.out.println("count = " + c2.next()); // c1,  c2는 같은 객체임으로 결과값은 ( 2 )
        System.out.println();
        System.out.println("===  프로토 타입 스코프  ===");
        PrototypeNote p1 = ac.getBean(PrototypeNote.class);
        PrototypeNote p2 = ac.getBean(PrototypeNote.class);
        System.out.println("p1 == p2 ? " + (p1 == p2)); // 프로토타입이라 객체가 2개 생김. 다른 객체임
        p1.write("첫 노트에 작성");
        p2.write("두번째 노트에 작성");
        p1.close();
        p2.close();
        System.out.println();
        System.out.println("===싱글톤 내부에서 프로토타입 사용===");
        SingletonWriter writer = ac.getBean(SingletonWriter.class); // 싱글톤이지만 안에서 프로토타입으로 객체생성
        writer.writeTwice("A메세지", "B메세지");
        System.out.println();
        System.out.println("===컨테이너 종료==="); // 싱글톤은 destroy 처리할 필요 없음 . (내부에선 destroy 해야함)
        ac.close();
    }
}
