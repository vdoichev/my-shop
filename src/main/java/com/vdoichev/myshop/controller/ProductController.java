package com.vdoichev.myshop.controller;

import com.vdoichev.myshop.dto.ProductDTO;
import com.vdoichev.myshop.facade.ProductFacade;
import com.vdoichev.myshop.services.ProductService;
import com.vdoichev.myshop.validations.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/shop")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductFacade productFacade;
    @Autowired
    private ProductService productService;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;

    @GetMapping("product/")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOList = productService.getAllProducts()
                .stream()
                .map(productFacade::productToProductDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    @GetMapping("product/{nameFilter}")
    public ResponseEntity<List<ProductDTO>> getProductsByNameFilter(@PathVariable("nameFilter") String nameFilter) {
        List<ProductDTO> productDTOList = productService.getProductsByNameFilter(nameFilter)
                .stream()
                .map(productFacade::productToProductDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

}
