package com.duvanlabrador.pizza.persistence.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginDto {
    private String username;
    private String password;
}
