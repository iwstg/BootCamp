package com.udemy.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class jdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(jdbcApplication.class, args);
    }
}

/*

testdb 를 사용

user 테이블 SQL

create table users (
    userId varchar(50) primary key,
    userName varchar(50) not null,
    age int
);

 */