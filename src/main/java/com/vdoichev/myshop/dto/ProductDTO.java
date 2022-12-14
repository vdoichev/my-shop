package com.vdoichev.myshop.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class ProductDTO {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
}
