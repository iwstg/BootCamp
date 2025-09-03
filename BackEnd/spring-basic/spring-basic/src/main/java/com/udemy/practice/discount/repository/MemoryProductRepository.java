package com.udemy.practice.discount.repository;

import com.udemy.practice.discount.domain.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> store = new HashMap<>();

    @Override
    public void save(Product product) {
        store.put(product.getId(), product);
    }

    @Override
    public Product findById(Long id) {
        return store.get(id);
    }

    @PostConstruct
    void init(){
        save(new Product(1L,"노트북", 1_500_000));
        save(new Product(2L,"키보드", 100_000));
        save(new Product(3L,"마우스", 50_000));
        System.out.println("[MemoryProductRepository] 샘플 데이터 적재 완료");
    }
}
