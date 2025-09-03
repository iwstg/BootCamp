package com.udemy.practice.discount;


import com.udemy.practice.discount.config.ScanConfig;
import com.udemy.practice.discount.repository.MemoryProductRepository;
import com.udemy.practice.discount.repository.ProductRepository;
import com.udemy.practice.discount.service.CheckoutService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class DiscountApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DiscountApplication.class, args);

        ApplicationContext ac = new AnnotationConfigApplicationContext(ScanConfig.class);

        CheckoutService check = ac.getBean(CheckoutService.class);

        check.checkout(1L);
        check.checkout(2L);
        check.checkout(3L);
        check.checkout(4L);


    }
}
