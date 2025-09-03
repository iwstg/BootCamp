package com.udemy.spring_basic.service;

import com.udemy.spring_basic.domain.Product;
import com.udemy.spring_basic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(@Qualifier("memoryProductRepository") ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product addProduct(String name, int price){
        return productRepository.save(new Product(null, name, price));
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
