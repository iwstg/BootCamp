package com.udemy.spring_basic.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleDemoMain {
    public static void main(String[] args) {
        // 1) 컨테이너 시작
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(LifeCycleScanConfig.class);

        // 2) 빈 사용
        LifeCycleFileWriter fileWriter = ac.getBean(LifeCycleFileWriter.class);
        fileWriter.writeLine("테스트 데이터 1");
        fileWriter.writeLine("테스트 데이터 2");

        // 3) 컨테이너 종료 (여기서 @PreDestroy 호출)
        ac.close();

        // 실행 후 프로젝트 루트에 output.txt 생성 및 내용 추가됨
    }
}