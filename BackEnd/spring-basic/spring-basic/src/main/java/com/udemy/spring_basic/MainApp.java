package com.udemy.spring_basic;

import com.udemy.spring_basic.config.ScanAppConfig;
import com.udemy.spring_basic.domain.Product;
import com.udemy.spring_basic.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // 스프링 컨테이너 실행 (basePackage 지정)
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.udemy.spring_basic");

        // ProductService 빈 가져오기
        ProductService productService = ac.getBean(ProductService.class);

        // 상품 등록
        productService.addProduct("노트북", 1500);
        productService.addProduct("키보드", 100);

        // 상품 목록 조회
        List<Product> products = productService.getProducts();

        // 결과 출력
        System.out.println("=== 상품 목록 ===");
        products.forEach(System.out::println);
    }
}