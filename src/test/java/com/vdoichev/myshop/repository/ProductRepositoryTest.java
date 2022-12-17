package com.vdoichev.myshop.repository;

import com.vdoichev.myshop.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findAllByOrderByName() {
        assertFalse(productRepository.findAll().iterator().hasNext());
        productRepository.saveAll(Arrays.asList(
                new Product(1L, "Phone", "Samsung"),
                new Product(2L, "phone", "Nokia"),
                new Product(3L, "TV", "Phillips"))
        );
        assertEquals(productRepository.findAllByOrderByName().size(), 3);
    }
}
