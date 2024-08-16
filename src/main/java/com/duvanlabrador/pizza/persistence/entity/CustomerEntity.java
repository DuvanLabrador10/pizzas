package com.duvanlabrador.pizza.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tb_customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    private Long idCustomer;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(length = 100)
    private String address;

    @Email
    @Column(nullable = false, unique = false, length = 50)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @OneToMany(
            targetEntity = OrderEntity.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "customer"
    )
    private List<OrderEntity> orders;
}
