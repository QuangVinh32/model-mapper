package com.vti.model.request;

import com.vti.model.entity.ProductStatus;
import com.vti.model.entity.ProductType;
import com.vti.model.entity.ShippingUnit;

import javax.validation.constraints.NotBlank;

public class CreateProductRequest {
    @NotBlank(message = "Không được bỏ trống")
    private String name;

    private String image;

    private int price;

    private ProductStatus status;

    private ShippingUnit shippingUnit;

    private ProductType type;
}
