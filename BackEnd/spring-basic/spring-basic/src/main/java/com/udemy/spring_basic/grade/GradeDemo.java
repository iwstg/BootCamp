package com.udemy.spring_basic.grade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class GradeDemo {
    public static void main(String[] args) {
        // 패키지 스캔 방식: 해당 패키지 하위의 @Component 들을 자동 등록
        ApplicationContext ac =
                new AnnotationConfigApplicationContext("com.udemy.spring_basic");

        // 1) 주입된 모든 Grade 전략 키/값 확인
        Map<String, Grade> all = ac.getBean(GradeService.class).getAllStrategies();
        System.out.println("=== 등록된 Grade 전략들 ===");
        all.forEach((k, v) -> System.out.println(" - " + k + " -> " + v.getClass().getSimpleName()));
        // 2) 서비스로 전략 선택 실행
        GradeService gradeService = ac.getBean(GradeService.class);

        GradeUser u1 = new GradeUser(1L, "ALice", "A"); // A → MASTER / (다른 전략에선 SUB or USER 등)
        GradeUser u2 = new GradeUser(2L, "Bob",   "B"); // B → ADMIN / (다른 전략에선 USER 등)

        String g1 = gradeService.getGrade(u1, "masterGrade"); // 구현체 이름!
        String g2 = gradeService.getGrade(u2, "subGrade");

        System.out.println("\n=== 실행 결과 ===");
        System.out.println("masterGrade(" + u1 + ") -> " + g1);
        System.out.println("subGrade("    + u2 + ") -> " + g2);

        try{
            gradeService.getGrade(u1, "noGrade");
        } catch (Exception e){
            System.out.println("에러메시지" + e.getMessage());
        }
    }
}
