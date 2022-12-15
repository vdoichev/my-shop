package com.vdoichev.myshop.services;

import com.vdoichev.myshop.entity.Product;
import com.vdoichev.myshop.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public static final Logger LOG = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllByOrderByName();
    }

    public List<Product> getProductsByNameFilter(String regex){

        List<Product> products = productRepository.myFindProductsByNameRegex(regex);
        LOG.info("getProductsByNameFilter: {}, result: {}", regex, products);
        return products;
    }
}
