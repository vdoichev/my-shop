package com.vdoichev.myshop.controller;

import com.vdoichev.myshop.dto.ProductDTO;
import com.vdoichev.myshop.facade.ProductFacade;
import com.vdoichev.myshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("shop/")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductFacade productFacade;
    @Autowired
    private ProductService productService;

    @GetMapping("product")
    public ResponseEntity<List<ProductDTO>> getProductsByNameFilter(@RequestParam(required = false) String nameFilter) {
        List<ProductDTO> productDTOList;
        if (nameFilter == null) {
            productDTOList = productService.getAllProducts()
                    .stream()
                    .map(productFacade::productToProductDto)
                    .collect(Collectors.toList());
        }else {
            productDTOList = productService.getProductsByNameFilter(nameFilter)
                    .stream()
                    .map(productFacade::productToProductDto)
                    .collect(Collectors.toList());
        }
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

}
