package com.udemy.spring_basic.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api3")
public class RequestProxyController {
    private final RequestProxyBean requestProxyBean;

    public RequestProxyController(RequestProxyBean requestProxyBean) {
        this.requestProxyBean = requestProxyBean;
    }

    @GetMapping("/request-proxy")
    public String getWithProxy() {
        System.out.println("ProxyCountroller " + requestProxyBean.getValue());
        return "ProxyCountroller " + requestProxyBean.getValue();
    }

}
