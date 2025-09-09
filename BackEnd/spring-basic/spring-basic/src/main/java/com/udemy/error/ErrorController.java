package com.udemy.error;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/test") // http://localhost:8080/error/test
    public void getTestError(HttpServletResponse response) throws IOException {
        log.error("테스트 에러 발생!!");
        response.sendError(404, "에러 발생");
    }
}
