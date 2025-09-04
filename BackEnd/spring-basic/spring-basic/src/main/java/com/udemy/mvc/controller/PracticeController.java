package com.udemy.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@Slf4j
public class PracticeController {
    @GetMapping("/path2") // "/path2?name=hello
    public boolean paramTest(
            @RequestParam(name = "name", defaultValue = "test", required = false) String name ){
        log.info("default Value Test = {}", name);
        return true;
    }

    @GetMapping("/path3") // "/path3?userId=id&userName=hello"
    public boolean paramMapTest(
            @RequestParam Map<String, Object> paramMap){
        String userName = (String) paramMap.get("userName");
        String userId = (String) paramMap.get("userId");
        log.info("userName = {}, userId = {}", userName, userId);
        return true;
    }
}
