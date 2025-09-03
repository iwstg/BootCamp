package com.udemy.practice.discount.repository;

import com.udemy.practice.discount.domain.Product;

public interface ProductRepository {
    void save(Product product);
    Product findById(Long id);
}
