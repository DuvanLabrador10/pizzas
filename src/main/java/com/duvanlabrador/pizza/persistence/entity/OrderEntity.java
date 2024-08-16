package com.duvanlabrador.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tb_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Long idOrder;

    @Column(name = "fe_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime feDate = LocalDateTime.now();

    @Column(nullable = false, columnDefinition = "Decimal (6,2)")
    private BigDecimal total;

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String method;

    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;

    @ManyToOne(
            targetEntity = CustomerEntity.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_customer")
    private CustomerEntity customer;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "idOrder"
    )
    private List<OrderItemEntity> orderItems;


}
