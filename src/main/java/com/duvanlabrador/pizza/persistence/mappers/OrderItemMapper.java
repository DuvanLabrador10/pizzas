package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.dto.OrderItemDto;
import com.duvanlabrador.pizza.persistence.entity.OrderItemEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface OrderItemMapper {


    @Mappings({
            @Mapping(source = "idItem", target = "idItem"),
            @Mapping(source = "idOrder.idOrder", target = "idOrder"),
            @Mapping(source = "idPizza.idPizza", target = "idPizza"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "price", target = "price"),
  })
    OrderItemDto orderItemToOrderItemDto(OrderItemEntity orderItem);

    @InheritInverseConfiguration
    OrderItemEntity orderItemDtoToOrderItem(OrderItemDto orderItemDto);
}
