package com.duvanlabrador.pizza.services.interfaces;

import com.duvanlabrador.pizza.persistence.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    public List<CustomerDto> getAllCustomers();
    public CustomerDto getCustomerById(Long idCustomer);
    public CustomerDto createCustomer(CustomerDto customerDto);
    public CustomerDto updateCustomer(Long idCustomer, CustomerDto customerDto);
    public Boolean deleteCustomerById(Long idCustomer);
}
