package com.udemy.practice.discount.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("noDiscountPolicy") // 할인 없는전략 적용 시, 사용됨
public class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(int price) {
        return 0;
    }
}
