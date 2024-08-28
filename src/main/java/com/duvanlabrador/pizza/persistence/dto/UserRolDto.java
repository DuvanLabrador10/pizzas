package com.duvanlabrador.pizza.persistence.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserRolDto {

    private Long userRolId;
    private String rolName;
    private LocalDateTime grantedDate;
}
