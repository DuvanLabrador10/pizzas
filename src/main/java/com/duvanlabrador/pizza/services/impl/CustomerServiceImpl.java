package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.exception.ResourceNotFoundException;
import com.duvanlabrador.pizza.persistence.dto.CustomerDto;
import com.duvanlabrador.pizza.persistence.entity.CustomerEntity;
import com.duvanlabrador.pizza.persistence.mappers.CustomerMapper;
import com.duvanlabrador.pizza.persistence.repository.CustomerRepository;
import com.duvanlabrador.pizza.services.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAllCustomers(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CustomerEntity> customer = this.customerRepository.findAll(pageable);
        if(customer.isEmpty()){
            return Collections.emptyList();
        }
        return customer.getContent().stream().map(this.customerMapper::customerToCustomerDto).toList();
    }

    @Secured("ROLE_ADMIN")//ONLY ROLE ADMIN CAN USE THIS METHOD
    @Override
    public CustomerDto getCustomerById(Long idCustomer) {
       verifyCustomer(idCustomer);
       CustomerEntity customer = this.customerRepository.findById(idCustomer).get();
       return this.customerMapper.customerToCustomerDto(customer);
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

    private void verifyCustomer(Long customerId){
        Optional<CustomerEntity> customer = this.customerRepository.findById(customerId);
        if (customer.isEmpty()){
            throw new ResourceNotFoundException("The customer whit id " + customer + " don't exist!");
        }
    }
}
