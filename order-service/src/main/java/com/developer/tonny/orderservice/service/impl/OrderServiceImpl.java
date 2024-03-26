package com.developer.tonny.orderservice.service.impl;

import org.springframework.stereotype.Service;

import com.developer.tonny.orderservice.model.OrderRequest;
import com.developer.tonny.orderservice.repository.OrderRepo;
import com.developer.tonny.orderservice.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    // private final WebClient.Builder webClientBuilder;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public String placeOrder(OrderRequest orderRequest) {
        return null;
    }

}
