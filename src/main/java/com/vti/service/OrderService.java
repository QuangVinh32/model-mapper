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

//        TypeMap<CreateOrderRequest, Order> propertyMapper =
//                mapper.createTypeMap(CreateOrderRequest.class, Order.class);
//        propertyMapper.addMappings(mapper -> mapper.skip(Order::setId));
        mapper.addMappings(skipModifiedFieldsMap);
        Order order = mapper.map(request, Order.class);
//        Order order = new Order();
        order.setAccount(account);
        order.setProduct(product);
//        order.setQuantity(request.getQuantity());

        repository.save(order);
    }

    PropertyMap<CreateOrderRequest, Order> skipModifiedFieldsMap =
            new PropertyMap<CreateOrderRequest, Order>() {
                protected void configure() {
                    skip().setId(null);
                }
            };

    @Override
    public void update(Order order) {
        repository.save(order);

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }
}
