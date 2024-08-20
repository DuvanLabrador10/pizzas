package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.persistence.dto.OrderItemDto;
import com.duvanlabrador.pizza.persistence.mappers.OrderItemMapper;
import com.duvanlabrador.pizza.persistence.mappers.OrderMapper;
import com.duvanlabrador.pizza.persistence.mappers.PizzaMapper;
import com.duvanlabrador.pizza.services.interfaces.OrderItemService;
import com.duvanlabrador.pizza.services.interfaces.OrderService;
import com.duvanlabrador.pizza.services.interfaces.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemService orderItemService;
    private final OrderItemMapper orderItemMapper;
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final PizzaService pizzaService;
    private final PizzaMapper pizzaMapper;

    @Override
    public List<OrderItemDto> getAllOrdersItems() {
        return List.of();
    }

    @Override
    public OrderItemDto createOrderItems(OrderItemDto orderItemDto, Long idOrder, Long idPizza) {
        return null;
    }
}
