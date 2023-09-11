package com.vti.model.request;

import com.vti.model.entity.ProductStatus;
import com.vti.model.entity.ProductType;
import com.vti.model.entity.ShippingUnit;

import java.util.Set;

public class SearchProductRequest {
    private String productName;

    private Set<ProductType> productTypes;

    private Set<ShippingUnit> shippingUnits;

    private Set<ProductStatus> productStatus;

    private Long minPrice;

    private Long maxPrice;
}
