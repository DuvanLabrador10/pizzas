package com.duvanlabrador.pizza.persistence.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private Boolean locked;
    private Boolean disabled;
}
