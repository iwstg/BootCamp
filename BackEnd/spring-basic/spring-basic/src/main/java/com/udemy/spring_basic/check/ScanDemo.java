package com.udemy.spring_basic.check;

import com.udemy.spring_basic.config.ScanAppConfig;
import com.udemy.spring_basic.repository.UsersRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScanDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ScanAppConfig.class);

        UsersRepository repo1 = ac.getBean(UsersRepository.class);
        UsersRepository repo2 = ac.getBean("usersRepository", UsersRepository.class);

        System.out.println("[SCAN] 타입으로 가져온 빈  = " + repo1);
        System.out.println("[SCAN] 이름으로 가져온 빈 = " + repo2);
        System.out.println("[SCAN] 같은 객체? " + (repo1 == repo2)); // true → 싱글톤
    }
}