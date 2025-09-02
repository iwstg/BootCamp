package com.udemy.spring_basic;

import com.udemy.spring_basic.config.AppConfig;
import com.udemy.spring_basic.repository.UsersRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonCheck {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        UsersRepository r1 = ac.getBean("usersRepository", UsersRepository.class);
        UsersRepository r2 = ac.getBean(UsersRepository.class); // 타입만으로도 검색 가능

        System.out.println("r1 == r2 ? " + (r1 == r2)); // true

    }
}
