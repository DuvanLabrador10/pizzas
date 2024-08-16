package com.duvanlabrador.pizza.persistence.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CustomerDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idCustomer;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String operation;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateEvent;
}
