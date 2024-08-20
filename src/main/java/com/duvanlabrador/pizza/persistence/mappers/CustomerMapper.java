package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.dto.CustomerDto;
import com.duvanlabrador.pizza.persistence.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CustomerMapper {

    CustomerDto customerToCustomerDto (CustomerEntity customer);

    @InheritInverseConfiguration
    CustomerEntity customerDtoToCustomer (CustomerDto customerDto);
}
