package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.dto.OrderItemDto;
import com.duvanlabrador.pizza.persistence.entity.OrderItemEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface OrderItemMapper {

    OrderItemDto orderItemToOrderItemDto(OrderItemEntity orderItem);

    @InheritInverseConfiguration
    OrderItemEntity orderItemDtoToOrderItem(OrderItemDto orderItemDto);
}
