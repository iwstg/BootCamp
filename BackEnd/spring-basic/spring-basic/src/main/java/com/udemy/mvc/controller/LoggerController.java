package com.udemy.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoggerController {
//    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);
    @GetMapping("/log")
    public String getLogTest(){
        System.out.println("일반 System.out.println");

//        위의 Logger logger을 사용한다면 아래처럼. @Slf4j 를 쓴다면 아래와 같이 사용
//        logger.trace("Trace 레벨 로그: 매우 상세한 로그입니다.");
//        logger.debug("Debug 레벨 로그: 디버깅용 로그입니다.");
//        logger.info("Info 레벨 로그: 애플리케이션 실행 정보입니다.");
//        logger.warn("Warn 레벨 로그: 주의가 필요한 상황입니다.");
//        logger.error("Error 레벨 로그: 에러가 발생했습니다!");

        log.trace("Trace 레벨 로그: 매우 상세한 로그입니다.");
        log.debug("Debug 레벨 로그: 디버깅용 로그입니다.");
        log.info("Info 레벨 로그: 애플리케이션 실행 정보입니다.");
        log.warn("Warn 레벨 로그: 주의가 필요한 상황입니다.");
        log.error("Error 레벨 로그: 에러가 발생했습니다!");

        String name =  "Spring"; // 코드상의 값도 log에서 뽑아 볼 수 있음.
        log.info("Info 로그 : Name : {}", name);

        return "로그테스트 완료";
    }


}
