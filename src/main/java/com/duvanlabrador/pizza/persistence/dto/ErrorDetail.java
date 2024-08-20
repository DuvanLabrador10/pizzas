package com.duvanlabrador.pizza.persistence.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Component
public class ErrorDetail {
    private String title;
    private Date dateTime;
    private int status;
    private String detail;
    private String developerMessage;
}
