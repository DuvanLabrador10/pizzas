package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.persistence.dto.OrderDto;
import com.duvanlabrador.pizza.persistence.mappers.CustomerMapper;
import com.duvanlabrador.pizza.persistence.mappers.OrderMapper;
import com.duvanlabrador.pizza.persistence.repository.CustomerRepository;
import com.duvanlabrador.pizza.persistence.repository.OrderRepository;
import com.duvanlabrador.pizza.services.interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public List<OrderDto> getAllOrders(int page, int size) {
        return List.of();
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto, Long idCustomer) {
        return null;
    }
}
