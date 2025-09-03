package com.udemy.spring_basic.grade;


import org.springframework.stereotype.Component;

@Component
public class MatserGrade implements Grade {
    @Override
    public String userGrade(GradeUser user) {
        return "A".equalsIgnoreCase(user.getRank())? "MASTER" : "SUB";
    }
}
