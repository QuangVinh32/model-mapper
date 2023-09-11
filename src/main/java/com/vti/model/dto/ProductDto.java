package com.vti.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String image;
    private int price;
    private String status;
    private String shippingUnit;
}
