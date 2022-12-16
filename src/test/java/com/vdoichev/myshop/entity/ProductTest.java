package com.vdoichev.myshop.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTest {
    @Test
    public void addProduct() {
        Product product = new Product(1L, "phone", "Samsung");
        assertEquals(1, product.getId(),
                "Actual result not expected for ID");
        assertEquals("phone", product.getName(),
                "Actual result not expected for NAME");
        assertEquals("Samsung", product.getDescription(),
                "Actual result not expected for DESCRIPTION");
    }

    @Test
    public void checkCountProduct(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "phone", "Samsung"));
        productList.add(new Product(2L, "TV", "Phillips"));
        productList.add(new Product(3L, "lamp", "Xiaomi"));
        assertEquals(3, productList.size(),"Actual result not expected for COUNT product");
    }
}
