package com.udemy.error.converter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/convert")
public class DateTestController {

    @GetMapping("/date")
    public String convertDate(@RequestParam("value") Date value){
        return "반환된 날짜 " + value.toString();
    }
}
