package com.udemy.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class RuntimeErrorTestController {
    @GetMapping("/errors/runtimes")
    public String boom(){
        log.info("인타임 에러 발생 트리거 실행");
        throw new RuntimeException("테스트로 Runtime exception 발생!");
    }
}
