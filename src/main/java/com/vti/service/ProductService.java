package com.vti.service;

import com.vti.model.entity.Product;
import com.vti.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository repository;

    @Override
    public Product findById(int id) {
//        Optional<Product> optional = repository.findById(id);
//        if (optional.isPresent()){
//            return optional.get();
//        }
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public Product findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void create(Product product) {
        repository.save(product);

    }

    @Override
    public void update(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }
}
