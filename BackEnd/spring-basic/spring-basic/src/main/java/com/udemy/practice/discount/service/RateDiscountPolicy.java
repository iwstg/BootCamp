package com.udemy.practice.discount.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //기본 전략으로 사용 (Qualifier 없이 주입됨)
public class RateDiscountPolicy implements DiscountPolicy {

    private final int ratePercent = 10; // 10% 할인

    @Override
    public int discount(int price) {
        return price * ratePercent / 100;
    }
}
