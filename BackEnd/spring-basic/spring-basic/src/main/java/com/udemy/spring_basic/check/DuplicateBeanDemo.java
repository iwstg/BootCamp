package com.udemy.spring_basic.check;

import com.udemy.spring_basic.config.DuplicatedBeanScanAppConfig;
import com.udemy.spring_basic.repository.UsersRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateBeanDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DuplicatedBeanScanAppConfig.class);

        UsersRepository repo1 = ac.getBean(UsersRepository.class);
        System.out.println("최종 userRepository" + repo1.getClass() + System.identityHashCode(repo1));

    }
}
