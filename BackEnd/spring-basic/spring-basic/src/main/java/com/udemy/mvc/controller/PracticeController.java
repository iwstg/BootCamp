package com.udemy.mvc.controller;

import com.udemy.mvc.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/path4") // "/path3?useridx=15&userId=id&userName=hello"
    public boolean modelAttributeTest(@ModelAttribute User user){
        log.info("userIdx = {}, userId = {}, userName = {}",user.getUserIdx(), user.getUserId(), user.getUserName());
        return true;
    }

    @GetMapping("/path/{userId}") // "/path/hello"
    public boolean pathTest(@PathVariable("userId") String userId){
        log.info("userIdx = {}", userId);
        return true;
    }

    @PostMapping("/path5") // "/path5" post로 폼데이터면 쿼리스트링으로, json이면 json 그대로
    public boolean requestBody(@RequestBody String message) {
        log.info("message body = {}", message);
        return true;
    }

    @GetMapping(value = "/header", headers = "Special=specialTest") // "/header" postMan에서 header로 key=value 전달
    public boolean headerTest(){
        log.info("specialTest");
        return true;
    }

    @GetMapping(
            value = "/produces-consumes",
            consumes = "application/json",
            produces = "application/json"
    )
    public String consumesProducesTest(){
        log.info("Consumes Json and Produces Json");
        return "{\"message\":\"Success\"}";
    }

}
