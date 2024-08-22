package com.duvanlabrador.pizza.persistence.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface OrderSummary {
    Long getIdOrders();
    Integer getQuantity();
    LocalDateTime getOrderDate();
    String getCustomerName();
    BigDecimal getOrderTotal();
    String getPizzaNames();
}
