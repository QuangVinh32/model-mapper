package com.vti.service;

import com.vti.model.entity.Account;
import com.vti.model.entity.Order;
import com.vti.model.entity.Product;
import com.vti.model.request.CreateOrderRequest;
import com.vti.repository.IOrderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IOrderRepository repository;

    @Autowired
    AccountService accountService;
    @Autowired
    ProductService productService;

    @Override
    public Page<Order> findByAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Order findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(CreateOrderRequest request) {

        Account account = new Account();
        account.setId(request.getAccountId());
        Product product = new Product();
        product.setId(request.getProductId());

        Order order = mapper.map(request, Order.class);
        order.setAccount(account);
        order.setProduct(product);

        repository.save(order);
    }

    @Override
    public void update(Order order) {
        repository.save(order);
// change logic
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }
}
