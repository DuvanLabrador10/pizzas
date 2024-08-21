package com.duvanlabrador.pizza.persistence.repository;

import com.duvanlabrador.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaEntity, Long> {
    @Query(value = "SELECT * FROM tb_pizza p WHERE p.available = true", nativeQuery = true)
    Optional<List<PizzaEntity>> findAllAvailablePizzas();
}
