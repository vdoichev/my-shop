package com.vdoichev.myshop.services;

import com.vdoichev.myshop.entity.Product;
import com.vdoichev.myshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllByOrderByName();
    }
}
