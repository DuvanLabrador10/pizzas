package com.duvanlabrador.pizza.services.interfaces;

import com.duvanlabrador.pizza.persistence.dto.OrderDto;

import java.util.List;

public interface OrderService {
    public List<OrderDto> getAllOrders();

    public OrderDto createOrder(OrderDto orderDto, Long idCustomer);


}
