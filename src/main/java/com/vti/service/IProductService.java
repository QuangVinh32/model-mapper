package com.vti.service;

import com.vti.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Product findById(int id);
    Page<Product> findAll(Pageable pageable);
    Product findByName(String name);
    void create(Product product);
    void update(Product product);
    void deleteById(int id);
}
