package com.duvanlabrador.pizza.persistence.repository;

import com.duvanlabrador.pizza.persistence.entity.UserRolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends JpaRepository<UserRolEntity, Long> {
}
