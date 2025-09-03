package com.udemy.spring_basic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 애플리케이션 시작 시 파일을 열고,
 * 비즈니스 로직에서 데이터를 쓰고,
 * 애플리케이션 종료 시 파일을 닫는 역할의 빈.
 */
@Component
public class LifeCycleFileWriter {

    private BufferedWriter writer;
    private final String fileName = "output.txt";

    public LifeCycleFileWriter() {
        System.out.println("생성자 호출: LifeCycleFileWriter 객체 생성");
    }

    // 의존성 주입 직후 호출: 리소스 초기화
    @PostConstruct
    public void init() {
        System.out.println("PostConstruct 호출: 파일 쓰기 작업 준비 중...");
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true)); // append 모드
            System.out.println("파일 열기 완료: " + fileName);
        } catch (IOException e) {
            System.err.println("파일 열기 실패: " + e.getMessage());
        }
    }
    // 비즈니스 로직: 파일에 한 줄 쓰기
    public void writeLine(String data) {
        System.out.println("파일에 데이터 쓰기 중...");
        try {
            writer.write(data);
            writer.newLine();
            writer.flush();
            System.out.println("데이터 쓰기 완료: " + data);
        } catch (IOException e) {
            System.err.println("데이터 쓰기 실패: " + e.getMessage());
        }
    }

    // 컨테이너 종료 직전 호출: 리소스 정리
    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy 호출: 파일 닫기 작업 시작...");
        try {
            if (writer != null) {
                writer.close();
                System.out.println("파일 닫기 완료: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("파일 닫기 실패: " + e.getMessage());
        }
    }
}