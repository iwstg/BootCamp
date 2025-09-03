package com.udemy.spring_basic.grade;

import org.springframework.stereotype.Component;

@Component
public class SubGrade implements Grade {
    @Override
    public String userGrade(GradeUser user) {
        return "B".equalsIgnoreCase(user.getRank())? "ADMIN" : "USER";
    }
}
