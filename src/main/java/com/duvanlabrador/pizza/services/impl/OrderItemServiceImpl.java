package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.persistence.dto.OrderItemDto;
import com.duvanlabrador.pizza.persistence.mappers.OrderItemMapper;
import com.duvanlabrador.pizza.persistence.mappers.OrderMapper;
import com.duvanlabrador.pizza.persistence.mappers.PizzaMapper;
import com.duvanlabrador.pizza.persistence.repository.OrderItemRepository;
import com.duvanlabrador.pizza.persistence.repository.OrderRepository;
import com.duvanlabrador.pizza.persistence.repository.PizzaRepository;
import com.duvanlabrador.pizza.services.interfaces.OrderItemService;
import com.duvanlabrador.pizza.services.interfaces.OrderService;
import com.duvanlabrador.pizza.services.interfaces.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    @Override
    public List<OrderItemDto> getAllOrdersItems(int page, int size) {
        return List.of();
    }

    @Override
    public OrderItemDto createOrderItems(OrderItemDto orderItemDto, Long idOrder, Long idPizza) {
        return null;
    }
}
