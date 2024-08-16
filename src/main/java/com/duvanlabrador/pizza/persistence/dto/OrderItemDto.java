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
public class OrderItemDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idItem;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idOrder;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idPizza;
    private Integer quantity;
    private BigDecimal price;
    private String operation;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateEvent;

}
