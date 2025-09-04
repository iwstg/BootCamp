package com.udemy.spring_basic.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class RequestProviderController {
    private final ObjectProvider<RequestProviderBean> requestProviderBeanProvider;

    public RequestProviderController(ObjectProvider<RequestProviderBean> requestProviderBeanProvider) {
        this.requestProviderBeanProvider = requestProviderBeanProvider;
    }

    @GetMapping("/request-scope") // ★ "/api" + "/request-scope" → "/api/request-scope"
    public String getRequestScope() {
        RequestProviderBean bean = requestProviderBeanProvider.getIfAvailable();
        System.out.println("RequestProviderController -> baen.getValue() " + bean.getValue());
        return "Request scope bean value: " + bean.getValue();
    }
}

