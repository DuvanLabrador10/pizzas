package com.duvanlabrador.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_item", nullable = false)
    private Long idItem;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private OrderEntity idOrder;

    @ManyToOne
    @JoinColumn(name = "id_pizza")
    private PizzaEntity idPizza;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, columnDefinition = "Decimal (5,2)")
    private BigDecimal price;
}
