package com.vdoichev.myshop.controller;

import com.vdoichev.myshop.entity.Product;
import com.vdoichev.myshop.facade.ProductFacade;
import com.vdoichev.myshop.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductFacade productFacade;
    @MockBean
    private ProductService productService;

    @Test
    void getProductsByNameFilterNotP() throws Exception {

        when(productService.getProductsByNameFilter("^P.*$")).thenReturn(Arrays.asList(
                new Product(2L, "phone", "Nokia"),
                new Product(3L, "TV", "Phillips")
        ));

        mockMvc.perform(get("/shop/product?nameFilter=^P.*$"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }

    @Test
    void getAllProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(Arrays.asList(
                new Product(1L, "Phone", "Samsung"),
                new Product(2L, "phone", "Nokia"),
                new Product(3L, "TV", "Phillips")
        ));

        mockMvc.perform(get("/shop/product/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }
}
