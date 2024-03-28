package com.developer.tonny.orderservice.service;

import com.developer.tonny.orderservice.model.OrderRequest;

public interface OrderService {

    String placeOrder(OrderRequest orderRequest);
}
