package com.duvanlabrador.pizza.web.controller;

import com.duvanlabrador.pizza.exception.ResourceBadRequestException;
import com.duvanlabrador.pizza.exception.ResourceForbidden;
import com.duvanlabrador.pizza.exception.ResourceNotFoundException;
import com.duvanlabrador.pizza.persistence.dto.CustomerDto;
import com.duvanlabrador.pizza.services.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden {
        List<CustomerDto> customer = this.customerService.getAllCustomers(page,size);
        if (customer.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerDto> getPizzaById(@PathVariable Long idCustomer) throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden {
        CustomerDto customer = this.customerService.getCustomerById(idCustomer);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
