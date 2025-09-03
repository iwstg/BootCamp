package com.udemy.practice.discount.service;

import com.udemy.practice.discount.domain.Product;
import com.udemy.practice.discount.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    private final ProductRepository productRepository;
    private final DiscountPolicy discountPolicy;

    public CheckoutService(ProductRepository productRepository,
                           DiscountPolicy discountPolicy) {
        this.productRepository = productRepository;
        this.discountPolicy = discountPolicy;
    }

    //discount 없는 방식으로 전략 변경 시
//    public CheckoutService(ProductRepository productRepository,
//                           @Qualifier("noDiscountPolicy")
//                           DiscountPolicy discountPolicy) {
//        this.productRepository = productRepository;
//        this.discountPolicy = discountPolicy;
//    }

    public int checkout(Long productId) {
        Product p = productRepository.findById(productId);
        if (p == null) throw new IllegalArgumentException("상품 없음: " + productId);

        int discount = discountPolicy.discount(p.getPrice());
        int finalPrice = p.getPrice() - discount;

        System.out.printf("[결제] 상품=%s, 정가=%d, 할인=%d, 결제금액=%d%n",
                p.getName(), p.getPrice(), discount, finalPrice);

        return finalPrice;
    }
}
