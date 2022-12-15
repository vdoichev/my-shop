package com.vdoichev.myshop.repository;

import com.vdoichev.myshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,
        ProductRepositoryCustom {
    List<Product> findAllByOrderByName();
}
