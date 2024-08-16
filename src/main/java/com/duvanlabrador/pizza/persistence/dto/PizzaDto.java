package com.duvanlabrador.pizza.persistence.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PizzaDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idPizza;
    private String name;
    private BigDecimal price;
    private Boolean Vegetarian;
    private Boolean Vegan;
    private Boolean available;
    private String operation;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateEvent;
}
