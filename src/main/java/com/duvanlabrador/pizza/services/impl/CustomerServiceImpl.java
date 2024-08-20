package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.persistence.dto.CustomerDto;
import com.duvanlabrador.pizza.persistence.mappers.CustomerMapper;
import com.duvanlabrador.pizza.persistence.repository.CustomerRepository;
import com.duvanlabrador.pizza.services.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerDto getCustomerById(Long idCustomer) {
        return null;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto updateCustomer(Long idCustomer, CustomerDto customerDto) {
        return null;
    }

    @Override
    public Boolean deleteCustomerById(Long idCustomer) {
        return null;
    }
}
