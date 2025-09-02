package com.udemy.spring_basic;

import com.udemy.spring_basic.config.AppConfig;
import com.udemy.spring_basic.repository.UsersRepository;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBasicApplication {

	public static void main(String[] args) {

        SpringApplication.run(SpringBasicApplication.class, args);

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        UsersRepository repo = ac.getBean("usersRepository", UsersRepository.class);
        System.out.println("정상 동작 : " + repo);

        try{
            Object notExist = ac.getBean("notExistBean");
        }catch (NoSuchBeanDefinitionException e){
            System.out.println("에러발생 " + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
	}

}
