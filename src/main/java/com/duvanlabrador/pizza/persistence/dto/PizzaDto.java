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
    private String description;
    private BigDecimal price;
    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean available;
    private String operation;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateEvent;
}
