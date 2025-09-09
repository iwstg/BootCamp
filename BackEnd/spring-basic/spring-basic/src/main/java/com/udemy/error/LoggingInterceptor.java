package com.udemy.error;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUUID = UUID.randomUUID().toString();
        request.setAttribute("requestUUID", requestUUID);

        log.info("요청 시작 로그 [{}] : {} {}", requestUUID, request.getMethod(), request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

       String requestUUID = (String) request.getAttribute("requestUUID");
       log.info("랜더링 전에 컨트롤러 실행 완료 [RequestUUID: {}]", requestUUID);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

        String  requestUUID = (String) request.getAttribute("requestUUID");
        if(ex != null){
            log.error("예외 발생 로그 [RequestUUID: {}]", requestUUID);
        }
        log.error("요청 완료 로그 [RequestUUID: {}]", requestUUID);
    }
}
