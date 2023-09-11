package com.vti.service;

import com.vti.model.entity.Account;
import com.vti.model.entity.Order;
import com.vti.model.request.CreateOrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    Page<Order> findByAll(Pageable pageable);
    Order findById(int id);
    void create(CreateOrderRequest request);
    void update(Order order);
    void deleteById(int id);


}
