package com.udemy.spring_basic.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RequestScopeController {
    private final RequestBean requestBean;

    public RequestScopeController(RequestBean requestBean) {
        this.requestBean = requestBean;
    }


    @GetMapping("/request-scope") // ★ "/api" + "/request-scope" → "/api/request-scope"
    public String getRequestScope() {
        return "Request scope bean value: " + requestBean.getValue();
    }
}

