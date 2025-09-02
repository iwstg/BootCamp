package com.udemy.spring_basic.singleton;

public class SingletonCautionService {
    private int amount; // ❌ 요청마다 달라지는 값을 필드에 저장 (공유 상태) 이거 지우면 각 다른 값을 가질 수 있음.

    public void order(int amount) {
        this.amount = amount;
    }
    public int getOrder() {
        return amount;
    }
}
