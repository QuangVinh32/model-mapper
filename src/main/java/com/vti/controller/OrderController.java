package com.vti.controller;

import com.vti.model.dto.OrderDto;
import com.vti.model.entity.Account;
import com.vti.model.entity.Order;
import com.vti.model.request.CreateOrderRequest;
import com.vti.service.IOrderService;
import com.vti.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IOrderService service;

    @GetMapping
    public Page<OrderDto> findByAll(Pageable pageable){
        Page<Order> page = service.findByAll(pageable);
        return page.map(new Function<Order, OrderDto>() {
            @Override
            public OrderDto apply(Order order) {
                return mapper.map(order,OrderDto.class) ;
            }
        });
    }
    @GetMapping("/{id}")
    public OrderDto findbyId(@PathVariable("id") int id){
        Order order = service.findById(id);
        return mapper.map(order,OrderDto.class);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateOrderRequest request){
        service.create(request);
        return ResponseEntity.ok("Thêm Order thành công");
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Order order) {
        service.update(order);
        return ResponseEntity.ok("Sửa Order thành công");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
        return ResponseEntity.ok("Xóa Order thành công");
    }
}
