package com.duvanlabrador.pizza.services.interfaces;

import com.duvanlabrador.pizza.persistence.dto.OrderItemDto;

import java.util.List;

public interface OrderItemService {

    public List<OrderItemDto> getAllOrdersItems(int page, int size);
    public OrderItemDto createOrderItems(OrderItemDto orderItemDto, Long idOrder, Long idPizza);
}
