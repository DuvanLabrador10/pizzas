package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.entity.PizzaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PizzaDto {

    PizzaDto pizzaToPizzaDto (PizzaEntity pizza);

    @InheritInverseConfiguration
    PizzaEntity pizzaDtoToPizza (PizzaDto pizzaDto);
}
