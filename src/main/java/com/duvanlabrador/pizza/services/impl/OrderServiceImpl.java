package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.exception.ResourceNotFoundException;
import com.duvanlabrador.pizza.persistence.dto.OrderDto;
import com.duvanlabrador.pizza.persistence.entity.OrderEntity;
import com.duvanlabrador.pizza.persistence.entity.PizzaEntity;
import com.duvanlabrador.pizza.persistence.mappers.CustomerMapper;
import com.duvanlabrador.pizza.persistence.mappers.OrderMapper;
import com.duvanlabrador.pizza.persistence.projections.OrderSummary;
import com.duvanlabrador.pizza.persistence.repository.CustomerRepository;
import com.duvanlabrador.pizza.persistence.repository.OrderRepository;
import com.duvanlabrador.pizza.services.interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public OrderSummary getSummary(Long orderId) {
        verifyOrder(orderId);
        return this.orderRepository.findSummary(orderId);
    }

    private void verifyOrder(Long orderId) {
        Optional<OrderEntity> order = this.orderRepository.findById(orderId);
        if (order.isEmpty()) {
            throw new ResourceNotFoundException("The order whit id " + orderId + " don't exist");
        }
    }
}
