package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.dto.CustomerDto;
import com.duvanlabrador.pizza.persistence.entity.CustomerEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CustomerMapper {


    @Mappings({
            @Mapping(source = "idCustomer", target = "idCustomer"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
    })
    CustomerDto customerToCustomerDto (CustomerEntity customer);

    @InheritInverseConfiguration
    CustomerEntity customerDtoToCustomer (CustomerDto customerDto);
}
