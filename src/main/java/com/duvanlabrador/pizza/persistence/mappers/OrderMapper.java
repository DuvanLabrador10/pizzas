package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.dto.OrderDto;
import com.duvanlabrador.pizza.persistence.entity.CustomerEntity;
import com.duvanlabrador.pizza.persistence.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface OrderMapper {

    OrderDto orderToOrderDto (CustomerEntity customer);

    @InheritInverseConfiguration
    OrderEntity orderDtoToOrder (OrderDto orderDto);
}
