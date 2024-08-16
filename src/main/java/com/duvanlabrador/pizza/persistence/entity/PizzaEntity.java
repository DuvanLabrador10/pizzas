package com.duvanlabrador.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tb_pizza")
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Long idPizza;

    @Column(unique = true, nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private BigDecimal price;

    @Column(columnDefinition = "TINYINT")
    private Boolean Vegetarian;

    @Column(columnDefinition = "TINYINT")
    private Boolean Vegan;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;

    @OneToMany(
            targetEntity = OrderItemEntity.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "idPizza"
    )
    private List<OrderItemEntity> orderItems;


}
