package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.dto.PizzaDto;
import com.duvanlabrador.pizza.persistence.entity.PizzaEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PizzaMapper {

    @Mappings({
            @Mapping(source = "idPizza", target = "idPizza"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "vegetarian", target = "vegetarian"),
            @Mapping(source = "vegan", target = "vegan"),
            @Mapping(source = "available", target = "available"),
            @Mapping(source = "operation", target = "operation"),
            @Mapping(source = "dateEvent", target = "dateEvent")
    })
    PizzaDto pizzaToPizzaDto(PizzaEntity pizza);

    @InheritInverseConfiguration
    PizzaEntity pizzaDtoToPizza(PizzaDto pizzaDto);
}
