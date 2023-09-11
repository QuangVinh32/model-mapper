package com.vti.configuration;

import com.vti.model.entity.Order;
import com.vti.model.request.CreateOrderRequest;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    ModelMapper modelMapper() {
       return new ModelMapper();

//        modelMapper.typeMap(CreateOrderRequest.class, Order.class)
//                .addMappings(mapper -> {
//                    mapper.map(CreateOrderRequest::getAccountId, Order::setAccount);
//                    mapper.map(CreateOrderRequest::getProductId, Order::setProduct);
//                });

//        return modelMapper;
    }
}
