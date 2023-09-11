package com.vti.controller;
import com.vti.model.dto.ProductDto;
import com.vti.model.entity.Product;
import com.vti.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IProductService service;
    @GetMapping
    Page<ProductDto> findAllProduct(Pageable pageable){
        Page<Product> page = service.findAll(pageable);
        return page.map(product -> mapper.map(product,ProductDto.class));
    }
    @GetMapping("/name/{name}")
    public ProductDto findByName(@PathVariable("name") String name){
        Product product = service.findByName(name);
        return mapper.map(product,ProductDto.class);


    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product) {
        service.create(product);
        return ResponseEntity.ok("Thêm Product thành công") ;
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product){
        service.update(product);
        return ResponseEntity.ok("Sửa Product thành công");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        service.deleteById(id);
        return ResponseEntity.ok("Xóa Product thành công");
    }


}
