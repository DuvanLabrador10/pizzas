package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.dto.OrderDto;
import com.duvanlabrador.pizza.persistence.entity.CustomerEntity;
import com.duvanlabrador.pizza.persistence.entity.OrderEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface OrderMapper {


    @Mappings({
            @Mapping(source = "idOrder", target = "idOrder"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "method", target = "method"),
            @Mapping(source = "additionalNotes", target = "additionalNotes"),
            @Mapping(source = "customer.idCustomer", target = "idCustomer"),
    })
    OrderDto orderToOrderDto (OrderEntity order);

    @InheritInverseConfiguration
    OrderEntity orderDtoToOrder (OrderDto orderDto);
}
