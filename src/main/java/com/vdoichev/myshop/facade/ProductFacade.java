package com.vdoichev.myshop.facade;

import com.vdoichev.myshop.dto.ProductDTO;
import com.vdoichev.myshop.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFacade {
    public ProductDTO productToProductDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());

        return productDTO;
    }
}
