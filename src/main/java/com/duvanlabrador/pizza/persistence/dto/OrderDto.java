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
public class OrderDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idOrder;
    private LocalDateTime feDate;
    private BigDecimal total;
    private String method;
    private String additionalNotes;
    private Long idCustomer;
}
