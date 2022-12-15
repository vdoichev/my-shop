package com.vdoichev.myshop.repository;

import com.vdoichev.myshop.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryCustom {
    List<Product> myFindProductsByNameRegex(String nameFilter);
}
